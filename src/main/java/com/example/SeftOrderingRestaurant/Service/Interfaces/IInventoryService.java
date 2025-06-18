/* *****************************************
 * CSCI 205 - Software Engineering and Design
 * Fall 2024
 * Instructor: Prof. Lily
 *
 * Name: Thu Le
 * Section: YOUR SECTION
 * Date: 05/06/2025
 * Time: 01:36
 *
 * Project: restaurant_mgt
 * Package: com.example.SeftOrderingRestaurant.Service.Interfaces
 * Class: IInventoryService
 *
 * Description:
 *
 * ****************************************
 */
package com.example.SeftOrderingRestaurant.Service.Interfaces;

import com.example.SeftOrderingRestaurant.Dtos.Request.InventoryRequestDto;
import com.example.SeftOrderingRestaurant.Dtos.Response.InventoryResponseDto;
import java.util.List;

/**
 * Service interface for handling inventory-related operations.
 */
public interface IInventoryService {
    /**
     * Create a new inventory item.
     *
     * @param request The inventory request containing inventory details
     * @return InventoryResponseDto containing the created inventory information
     */
    InventoryResponseDto createInventoryItem(InventoryRequestDto request);

    /**
     * Get an inventory item by its ID.
     *
     * @param inventoryId The ID of the inventory item to retrieve
     * @return InventoryResponseDto containing the inventory information
     */
    InventoryResponseDto getInventoryItemById(Long inventoryId);

    /**
     * Get all inventory items.
     *
     * @return List of InventoryResponseDto containing all inventory items
     */
    List<InventoryResponseDto> getAllInventoryItems();

    /**
     * Update an inventory item's information.
     *
     * @param inventoryId The ID of the inventory item to update
     * @param request The inventory request containing updated details
     * @return InventoryResponseDto containing the updated inventory information
     */
    InventoryResponseDto updateInventoryItem(Long inventoryId, InventoryRequestDto request);

    /**
     * Delete an inventory item.
     *
     * @param inventoryId The ID of the inventory item to delete
     */
    void deleteInventoryItem(Long inventoryId);

    /**
     * Update inventory quantity.
     *
     * @param inventoryId The ID of the inventory item to update
     * @param quantity The new quantity
     * @return InventoryResponseDto containing the updated inventory information
     */
    InventoryResponseDto updateInventoryQuantity(Long inventoryId, Integer quantity);

    /**
     * Get inventory items by category.
     *
     * @param category The category to filter by
     * @return List of InventoryResponseDto containing inventory items in the specified category
     */
    List<InventoryResponseDto> getInventoryItemsByCategory(String category);

    /**
     * Get low stock inventory items.
     *
     * @param threshold The minimum quantity threshold
     * @return List of InventoryResponseDto containing inventory items with quantity below threshold
     */
    List<InventoryResponseDto> getLowStockItems(Integer threshold);

    /**
     * Get inventory items by supplier.
     *
     * @param supplierId The ID of the supplier
     * @return List of InventoryResponseDto containing inventory items from the supplier
     */
    List<InventoryResponseDto> getInventoryItemsBySupplier(Long supplierId);
}