/* *****************************************
 * CSCI 205 - Software Engineering and Design
 * Fall 2024
 * Instructor: Prof. Lily
 *
 * Name: Thu Le
 * Section: YOUR SECTION
 * Date: 05/06/2025
 * Time: 01:37
 *
 * Project: restaurant_mgt
 * Package: com.example.SeftOrderingRestaurant.Service.Interfaces
 * Class: IOrderServiceItemsService
 *
 * Description:
 *
 * ****************************************
 */
package com.example.SeftOrderingRestaurant.Service.Interfaces;

import com.example.SeftOrderingRestaurant.Dtos.Request.OrderItemRequestDto;
import com.example.SeftOrderingRestaurant.Dtos.Response.OrderItemResponseDto;
import java.util.List;

/**
 * Service interface for handling order item-related operations.
 */
public interface IOrderServiceItemsService {
    /**
     * Create a new order item.
     *
     * @param request The order item request containing order item details
     * @return OrderItemResponseDto containing the created order item information
     */
    OrderItemResponseDto createOrderItem(OrderItemRequestDto request);

    /**
     * Get an order item by its ID.
     *
     * @param orderItemId The ID of the order item to retrieve
     * @return OrderItemResponseDto containing the order item information
     */
    OrderItemResponseDto getOrderItemById(Long orderItemId);

    /**
     * Get all order items for an order.
     *
     * @param orderId The ID of the order
     * @return List of OrderItemResponseDto containing order items for the order
     */
    List<OrderItemResponseDto> getOrderItemsByOrder(Long orderId);

    /**
     * Update an order item's information.
     *
     * @param orderItemId The ID of the order item to update
     * @param request The order item request containing updated details
     * @return OrderItemResponseDto containing the updated order item information
     */
    OrderItemResponseDto updateOrderItem(Long orderItemId, OrderItemRequestDto request);

    /**
     * Delete an order item.
     *
     * @param orderItemId The ID of the order item to delete
     */
    void deleteOrderItem(Long orderItemId);

    /**
     * Update order item status.
     *
     * @param orderItemId The ID of the order item to update
     * @param status The new status
     * @return OrderItemResponseDto containing the updated order item information
     */
    OrderItemResponseDto updateOrderItemStatus(Long orderItemId, String status);

    /**
     * Get order items by status.
     *
     * @param status The status to filter by
     * @return List of OrderItemResponseDto containing order items with the specified status
     */
    List<OrderItemResponseDto> getOrderItemsByStatus(String status);

    /**
     * Get order items by dish.
     *
     * @param dishId The ID of the dish
     * @return List of OrderItemResponseDto containing order items for the dish
     */
    List<OrderItemResponseDto> getOrderItemsByDish(Long dishId);
}