package com.example.SeftOrderingRestaurant.Service.Interfaces;

import com.example.SeftOrderingRestaurant.Dtos.Request.OrderRequestDto;
import com.example.SeftOrderingRestaurant.Dtos.Response.OrderResponseDto;
import java.util.List;

/**
 * Service interface for handling order-related operations.
 */
public interface OrderService {
    /**
     * Create a new order.
     *
     * @param request The order request containing order details
     * @return OrderResponseDto containing the created order information
     */
    OrderResponseDto createOrder(OrderRequestDto request);

    /**
     * Get an order by its ID.
     *
     * @param orderId The ID of the order to retrieve
     * @return OrderResponseDto containing the order information
     */
    OrderResponseDto getOrderById(Long orderId);

    /**
     * Get all orders for a specific customer.
     *
     * @param customerId The ID of the customer
     * @return List of OrderResponseDto containing the customer's orders
     */
    List<OrderResponseDto> getCustomerOrders(Long customerId);

    /**
     * Update the status of an order.
     *
     * @param orderId The ID of the order to update
     * @param status The new status to set
     * @return OrderResponseDto containing the updated order information
     */
    OrderResponseDto updateOrderStatus(Long orderId, String status);

    /**
     * Cancel an order.
     *
     * @param orderId The ID of the order to cancel
     * @return OrderResponseDto containing the cancelled order information
     */
    OrderResponseDto cancelOrder(Long orderId);

    /**
     * Get all active orders.
     *
     * @return List of OrderResponseDto containing all active orders
     */
    List<OrderResponseDto> getActiveOrders();

    /**
     * Get orders by date range.
     *
     * @param startDate The start date of the range
     * @param endDate The end date of the range
     * @return List of OrderResponseDto containing orders within the date range
     */
    List<OrderResponseDto> getOrdersByDateRange(String startDate, String endDate);
} 