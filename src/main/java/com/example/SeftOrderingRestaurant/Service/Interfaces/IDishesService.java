/* *****************************************
 * CSCI 205 - Software Engineering and Design
 * Fall 2024
 * Instructor: Prof. Lily
 *
 * Name: Thu Le
 * Section: YOUR SECTION
 * Date: 05/06/2025
 * Time: 01:35
 *
 * Project: restaurant_mgt
 * Package: com.example.SeftOrderingRestaurant.Service.Interfaces
 * Class: IDishesService
 *
 * Description:
 *
 * ****************************************
 */
package com.example.SeftOrderingRestaurant.Service.Interfaces;

import com.example.SeftOrderingRestaurant.Dtos.Request.DishRequestDto;
import com.example.SeftOrderingRestaurant.Dtos.Response.DishResponseDto;
import java.util.List;

/**
 * Service interface for handling dish-related operations.
 */
public interface IDishesService {
    /**
     * Create a new dish.
     *
     * @param request The dish request containing dish details
     * @return DishResponseDto containing the created dish information
     */
    DishResponseDto createDish(DishRequestDto request);

    /**
     * Get a dish by its ID.
     *
     * @param dishId The ID of the dish to retrieve
     * @return DishResponseDto containing the dish information
     */
    DishResponseDto getDishById(Long dishId);

    /**
     * Get all dishes.
     *
     * @return List of DishResponseDto containing all dishes
     */
    List<DishResponseDto> getAllDishes();

    /**
     * Update a dish's information.
     *
     * @param dishId The ID of the dish to update
     * @param request The dish request containing updated details
     * @return DishResponseDto containing the updated dish information
     */
    DishResponseDto updateDish(Long dishId, DishRequestDto request);

    /**
     * Delete a dish.
     *
     * @param dishId The ID of the dish to delete
     */
    void deleteDish(Long dishId);

    /**
     * Get dishes by category.
     *
     * @param categoryId The ID of the category
     * @return List of DishResponseDto containing dishes in the specified category
     */
    List<DishResponseDto> getDishesByCategory(Long categoryId);

    /**
     * Get dishes by price range.
     *
     * @param minPrice The minimum price
     * @param maxPrice The maximum price
     * @return List of DishResponseDto containing dishes within the price range
     */
    List<DishResponseDto> getDishesByPriceRange(Double minPrice, Double maxPrice);

    /**
     * Update dish availability.
     *
     * @param dishId The ID of the dish to update
     * @param available The new availability status
     * @return DishResponseDto containing the updated dish information
     */
    DishResponseDto updateDishAvailability(Long dishId, boolean available);

    /**
     * Get all available dishes.
     *
     * @return List of DishResponseDto containing all available dishes
     */
    List<DishResponseDto> getAvailableDishes();
}