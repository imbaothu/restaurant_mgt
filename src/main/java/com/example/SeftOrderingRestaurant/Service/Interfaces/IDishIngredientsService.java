
package com.example.SeftOrderingRestaurant.Service.Interfaces;

import com.example.SeftOrderingRestaurant.Dtos.Request.DishIngredientsRequestDto;
import com.example.SeftOrderingRestaurant.Dtos.Response.DishIngredientsResponseDto;
import java.util.List;

public interface IDishIngredientsService {
    DishIngredientsResponseDto createDishIngredient(DishIngredientsRequestDto requestDto);
    DishIngredientsResponseDto getDishIngredientById(Long id);
    List<DishIngredientsResponseDto> getAllDishIngredients();
    DishIngredientsResponseDto updateDishIngredient(Long id, DishIngredientsRequestDto requestDto);
    void deleteDishIngredient(Long id);
    List<DishIngredientsResponseDto> getIngredientsByDish(Long dishId);
    List<DishIngredientsResponseDto> getDishesByIngredient(Long ingredientId);
}