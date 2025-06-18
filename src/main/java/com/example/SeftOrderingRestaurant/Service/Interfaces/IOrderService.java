
package com.example.SeftOrderingRestaurant.Service.Interfaces;

import com.example.SeftOrderingRestaurant.Dtos.Request.OrderRequestDto;
import com.example.SeftOrderingRestaurant.Dtos.Response.OrderResponseDto;
import com.example.SeftOrderingRestaurant.Entities.OrderItems;
import com.example.SeftOrderingRestaurant.Entities.Payments;
import com.example.SeftOrderingRestaurant.Enums.OrderItemStatus;
import com.example.SeftOrderingRestaurant.Enums.OrderStatus;

import java.util.List;


public class IOrderService {
    OrderResponseDto createOrder(OrderRequestDto request);
    OrderResponseDto updateStatus(Long orderId, OrderStatus status);
    OrderItems updateOrderItemStatus(Long orderItemId, OrderItemStatus status);
    Payments processPayment(Long orderId, Payments payment);
    OrderResponseDto getOrderById(Long orderId);
    List<OrderResponseDto> getCustomerOrders(Long customerId);
    List<OrderResponseDto> getOrderByStatus(OrderStatus status);
    List<OrderResponseDto> getAllOrders();

}