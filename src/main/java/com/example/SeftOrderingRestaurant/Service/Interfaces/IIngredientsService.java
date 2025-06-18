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
 * Class: IIngredientsService
 *
 * Description:
 *
 * ****************************************
 */
package com.example.SeftOrderingRestaurant.Service.Interfaces;

import com.example.SeftOrderingRestaurant.Dtos.Request.IngredientRequestDto;
import com.example.SeftOrderingRestaurant.Dtos.Response.IngredientResponseDto;
import java.util.List;

public interface IIngredientsService {
    IngredientResponseDto createIngredient(IngredientRequestDto requestDto);
    IngredientResponseDto getIngredientById(Long id);
    List<IngredientResponseDto> getAllIngredients();
    IngredientResponseDto updateIngredient(Long id, IngredientRequestDto requestDto);
    void deleteIngredient(Long id);
    List<IngredientResponseDto> getIngredientsByCategory(String category);
    List<IngredientResponseDto> getIngredientsBySupplier(Long supplierId);
}