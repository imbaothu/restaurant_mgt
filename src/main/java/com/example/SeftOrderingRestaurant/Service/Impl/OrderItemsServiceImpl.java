/* *****************************************
 * CSCI 205 - Software Engineering and Design
 * Fall 2024
 * Instructor: Prof. Lily
 *
 * Name: Thu Le
 * Section: YOUR SECTION
 * Date: 05/06/2025
 * Time: 01:27
 *
 * Project: restaurant_mgt
 * Package: com.example.SeftOrderingRestaurant.Service.Impl
 * Class: OrderItemsServiceImpl
 *
 * Description:
 *
 * ****************************************
 */
package com.example.SeftOrderingRestaurant.Service.Impl;

import com.example.SeftOrderingRestaurant.Dtos.Request.OrderItemRequestDto;
import com.example.SeftOrderingRestaurant.Dtos.Response.OrderItemResponseDto;
import com.example.SeftOrderingRestaurant.Service.Interfaces.IOrderServiceItemsService;
import com.example.SeftOrderingRestaurant.Models.OrderItem;
import com.example.SeftOrderingRestaurant.Repositories.OrderItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderItemsServiceImpl implements IOrderServiceItemsService {

    private final OrderItemRepository orderItemRepository;

    @Override
    public OrderItemResponseDto createOrderItem(OrderItemRequestDto requestDto) {
        OrderItem orderItem = new OrderItem();
        orderItem.setOrderId(requestDto.getOrderId());
        orderItem.setDishId(requestDto.getDishId());
        orderItem.setQuantity(requestDto.getQuantity());
        orderItem.setSpecialInstructions(requestDto.getSpecialInstructions());
        orderItem.setCustomizationIds(requestDto.getCustomizationIds());
        orderItem.setStatus(requestDto.getStatus());
        orderItem = orderItemRepository.save(orderItem);
        return mapToResponseDto(orderItem);
    }

    @Override
    public OrderItemResponseDto getOrderItemById(Long id) {
        OrderItem orderItem = orderItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order item not found"));
        return mapToResponseDto(orderItem);
    }

    @Override
    public List<OrderItemResponseDto> getAllOrderItems() {
        return orderItemRepository.findAll().stream()
                .map(this::mapToResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public OrderItemResponseDto updateOrderItem(Long id, OrderItemRequestDto requestDto) {
        OrderItem orderItem = orderItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order item not found"));
        orderItem.setOrderId(requestDto.getOrderId());
        orderItem.setDishId(requestDto.getDishId());
        orderItem.setQuantity(requestDto.getQuantity());
        orderItem.setSpecialInstructions(requestDto.getSpecialInstructions());
        orderItem.setCustomizationIds(requestDto.getCustomizationIds());
        orderItem.setStatus(requestDto.getStatus());
        orderItem = orderItemRepository.save(orderItem);
        return mapToResponseDto(orderItem);
    }

    @Override
    public void deleteOrderItem(Long id) {
        orderItemRepository.deleteById(id);
    }

    @Override
    public List<OrderItemResponseDto> getOrderItemsByOrder(Long orderId) {
        return orderItemRepository.findByOrderId(orderId).stream()
                .map(this::mapToResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<OrderItemResponseDto> getOrderItemsByStatus(String status) {
        return orderItemRepository.findByStatus(status).stream()
                .map(this::mapToResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<OrderItemResponseDto> getOrderItemsByDish(Long dishId) {
        return orderItemRepository.findByDishId(dishId).stream()
                .map(this::mapToResponseDto)
                .collect(Collectors.toList());
    }

    private OrderItemResponseDto mapToResponseDto(OrderItem orderItem) {
        OrderItemResponseDto responseDto = new OrderItemResponseDto();
        responseDto.setId(orderItem.getId());
        responseDto.setOrderId(orderItem.getOrderId());
        responseDto.setDishId(orderItem.getDishId());
        responseDto.setDishName(orderItem.getDishName());
        responseDto.setQuantity(orderItem.getQuantity());
        responseDto.setPrice(orderItem.getPrice());
        responseDto.setSpecialInstructions(orderItem.getSpecialInstructions());
        responseDto.setCustomizations(orderItem.getCustomizations());
        responseDto.setStatus(orderItem.getStatus());
        responseDto.setCreatedAt(orderItem.getCreatedAt());
        responseDto.setUpdatedAt(orderItem.getUpdatedAt());
        return responseDto;
    }
}