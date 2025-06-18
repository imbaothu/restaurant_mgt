/* *****************************************
 * CSCI 205 - Software Engineering and Design
 * Fall 2024
 * Instructor: Prof. Lily
 *
 * Name: Thu Le
 * Section: YOUR SECTION
 * Date: 05/06/2025
 * Time: 01:34
 *
 * Project: restaurant_mgt
 * Package: com.example.SeftOrderingRestaurant.Service.Interfaces
 * Class: ICategoriesService
 *
 * Description:
 *
 * ****************************************
 */
package com.example.SeftOrderingRestaurant.Service.Interfaces;

import com.example.SeftOrderingRestaurant.Dtos.Request.CategoryRequestDto;
import com.example.SeftOrderingRestaurant.Dtos.Response.CategoryResponseDto;
import java.util.List;

/**
 * Service interface for handling category-related operations.
 */
public interface ICategoriesService {
    /**
     * Create a new category.
     *
     * @param request The category request containing category details
     * @return CategoryResponseDto containing the created category information
     */
    CategoryResponseDto createCategory(CategoryRequestDto request);

    /**
     * Get a category by its ID.
     *
     * @param categoryId The ID of the category to retrieve
     * @return CategoryResponseDto containing the category information
     */
    CategoryResponseDto getCategoryById(Long categoryId);

    /**
     * Get all categories.
     *
     * @return List of CategoryResponseDto containing all categories
     */
    List<CategoryResponseDto> getAllCategories();

    /**
     * Update a category's information.
     *
     * @param categoryId The ID of the category to update
     * @param request The category request containing updated details
     * @return CategoryResponseDto containing the updated category information
     */
    CategoryResponseDto updateCategory(Long categoryId, CategoryRequestDto request);

    /**
     * Delete a category.
     *
     * @param categoryId The ID of the category to delete
     */
    void deleteCategory(Long categoryId);

    /**
     * Get categories by type.
     *
     * @param type The type of categories to retrieve
     * @return List of CategoryResponseDto containing categories of the specified type
     */
    List<CategoryResponseDto> getCategoriesByType(String type);
}