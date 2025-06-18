package com.example.SeftOrderingRestaurant.Service.Impl;

import com.example.SeftOrderingRestaurant.Dtos.Common.OrderCommonDto;
import com.example.SeftOrderingRestaurant.Dtos.Request.OrderRequestDto;
import com.example.SeftOrderingRestaurant.Dtos.Response.OrderResponseDto;
import com.example.SeftOrderingRestaurant.Entities.*;
import com.example.SeftOrderingRestaurant.Enums.*;
import com.example.SeftOrderingRestaurant.Exceptions.ResourceNotFoundException;
import com.example.SeftOrderingRestaurant.Repositories.*;
import com.example.SeftOrderingRestaurant.Service.Interfaces.OrderService;
import com.example.SeftOrderingRestaurant.Service.Interfaces.IInventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrdersRepository ordersRepository;
    private final OrderItemsRepository orderItemsRepository;
    private final CustomerRepository customerRepository;
    private final DishesRepository dishesRepository;
    private final PaymentsRepository paymentsRepository;
    private final InventoryService inventoryService;

    @Override
    public OrderResponseDto createOrder(OrderRequestDto request) {
        if (request.getDishIds().size() != request.getQuantities().size())
            throw new IllegalArgumentException("Dish IDs and quantities must match");

        Customer customer = customerRepository.findById(request.getCustomerId())
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found"));

        Orders order = new Orders();
        order.setCustomerId(request.getCustomerId());
        order.setOrderTime(LocalDateTime.now());
        order.setOrderStatus(OrderStatus.PENDING);
        order.setOrderPaymentStatus(OrderPaymentStatus.UNPAID);
        order.setTotalAmount(BigDecimal.ZERO);
        Orders savedOrder = ordersRepository.save(order);

        // Process items and calculate total
        BigDecimal total = BigDecimal.ZERO;
        List<OrderItems> items = new ArrayList<>();
        for (int i = 0; i < request.getDishIds().size(); i++) {
            Dishes dish = dishesRepository.findById(request.getDishIds().get(i))
                    .orElseThrow(() -> new ResourceNotFoundException("Dish not found"));
            if (dish.getStatus() != DishStatus.AVAILABLE)
                throw new IllegalArgumentException("Dish unavailable: " + dish.getName());
            if (!inventoryService.checkIngredientsAvailability(dish.getId(), request.getQuantities().get(i)))
                throw new IllegalArgumentException("Insufficient ingredients for: " + dish.getName());

            OrderItems item = new OrderItems();
            item.setOrderId(savedOrder.getId());
            item.setDishId(dish.getId());
            item.setQuantity(request.getQuantities().get(i));
            item.setPrice(dish.getPrice());
            item.setSubtotal(dish.getPrice().multiply(BigDecimal.valueOf(item.getQuantity())));
            item.setStatus(OrderItemStatus.ORDERED);
            items.add(item);
            total = total.add(item.getSubtotal());

            inventoryService.updateInventoryForDish(dish.getId(), item.getQuantity());
        }

        orderItemsRepository.saveAll(items);
        savedOrder.setTotalAmount(total);
        ordersRepository.save(savedOrder);

        return getOrderById(savedOrder.getId());
    }

    @Override
    public OrderResponseDto getOrderById(Long orderId) {
        Orders order = ordersRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found"));
        String customerName = customerRepository.findById(order.getCustomerId())
                .map(Customer::getName).orElse("Unknown");

        OrderResponseDto dto = new OrderResponseDto();
        dto.setOrderId(Long.valueOf(order.getId()));
        dto.setCustomerId(order.getCustomerId());
        dto.setCustomerName(customerName);
        dto.setOrderTime(order.getOrderTime());
        dto.setTotalAmount(order.getTotalAmount());
        dto.setStatus(order.getOrderStatus());
        dto.setPaymentStatus(order.getOrderPaymentStatus());

        List<OrderItems> items = orderItemsRepository.findByOrderId(orderId);
        dto.setItems(items.stream().map(item -> {
            OrderCommonDto itemDto = new OrderCommonDto();
            BeanUtils.copyProperties(item, itemDto);
            itemDto.setDishName(dishesRepository.findById(item.getDishId())
                    .map(Dishes::getName).orElse("Unknown"));
            return itemDto;
        }).collect(Collectors.toList()));

        return dto;
    }

    @Override
    public List<OrderResponseDto> getCustomerOrders(Long customerId) {
        if (!customerRepository.existsById(customerId))
            throw new ResourceNotFoundException("Customer not found");
        return ordersRepository.findByCustomerIdOrderByOrderTimeDesc(customerId).stream()
                .map(order -> getOrderById(order.getId())).collect(Collectors.toList());
    }

    @Override
    public OrderResponseDto updateOrderStatus(Long orderId, String status) {
        Orders order = ordersRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found"));
        order.setOrderStatus(OrderStatus.valueOf(status));
        List<OrderItems> items = orderItemsRepository.findByOrderId(orderId);

        if (status.equals(OrderStatus.COMPLETED.name()) || status.equals(OrderStatus.CANCELLED.name())) {
            items.forEach(item -> {
                if (status.equals(OrderStatus.COMPLETED.name()) && item.getStatus() != OrderItemStatus.CANCELLED)
                    item.setStatus(OrderItemStatus.SERVED);
                else if (status.equals(OrderStatus.CANCELLED.name()) && item.getStatus() != OrderItemStatus.CANCELLED) {
                    item.setStatus(OrderItemStatus.CANCELLED);
                    inventoryService.returnInventoryForDish(item.getDishId(), item.getQuantity());
                }
            });
            orderItemsRepository.saveAll(items);
        }

        return getOrderById(ordersRepository.save(order).getId());
    }

    @Override
    public OrderResponseDto cancelOrder(Long orderId) {
        return updateOrderStatus(orderId, OrderStatus.CANCELLED.name());
    }

    @Override
    public List<OrderResponseDto> getActiveOrders() {
        return ordersRepository.findByOrderStatusNot(OrderStatus.COMPLETED).stream()
                .map(order -> getOrderById(order.getId())).collect(Collectors.toList());
    }

    @Override
    public List<OrderResponseDto> getOrdersByDateRange(String startDate, String endDate) {
        LocalDateTime start = LocalDateTime.parse(startDate);
        LocalDateTime end = LocalDateTime.parse(endDate);
        return ordersRepository.findByOrderTimeBetween(start, end).stream()
                .map((Orders order) -> getOrderById(order.getId().longValue()))
                .collect(Collectors.toList());
    }
}