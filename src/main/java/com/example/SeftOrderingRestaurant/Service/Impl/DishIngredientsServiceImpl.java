/* *****************************************
 * CSCI 205 - Software Engineering and Design
 * Fall 2024
 * Instructor: Prof. Lily
 *
 * Name: Thu Le
 * Section: YOUR SECTION
 * Date: 05/06/2025
 * Time: 01:26
 *
 * Project: restaurant_mgt
 * Package: com.example.SeftOrderingRestaurant.Service.Impl
 * Class: DishIngredientsServiceImpl
 *
 * Description:
 *
 * ****************************************
 */
package com.example.SeftOrderingRestaurant.Service.Impl;

import com.example.SeftOrderingRestaurant.Dtos.Request.DishIngredientsRequestDto;
import com.example.SeftOrderingRestaurant.Dtos.Response.DishIngredientsResponseDto;
import com.example.SeftOrderingRestaurant.Service.Interfaces.IDishIngredientsService;
import com.example.SeftOrderingRestaurant.Entities.DishIngredient;
import com.example.SeftOrderingRestaurant.Repositories.DishIngredientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class DishIngredientsServiceImpl implements IDishIngredientsService {

    private final DishIngredientRepository dishIngredientRepository;

    @Override
    public DishIngredientsResponseDto createDishIngredient(DishIngredientsRequestDto requestDto) {
        DishIngredient dishIngredient = new DishIngredient();
        dishIngredient.setDishId(requestDto.getDishId());
        dishIngredient.setIngredientId(requestDto.getIngredientId());
        dishIngredient.setQuantity(requestDto.getQuantity());
        dishIngredient.setUnit(requestDto.getUnit());
        dishIngredient = dishIngredientRepository.save(dishIngredient);
        return mapToResponseDto(dishIngredient);
    }

    @Override
    public DishIngredientsResponseDto getDishIngredientById(Long id) {
        DishIngredient dishIngredient = dishIngredientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dish ingredient not found"));
        return mapToResponseDto(dishIngredient);
    }

    @Override
    public List<DishIngredientsResponseDto> getAllDishIngredients() {
        return dishIngredientRepository.findAll().stream()
                .map(this::mapToResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public DishIngredientsResponseDto updateDishIngredient(Long id, DishIngredientsRequestDto requestDto) {
        DishIngredient dishIngredient = dishIngredientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dish ingredient not found"));
        dishIngredient.setDishId(requestDto.getDishId());
        dishIngredient.setIngredientId(requestDto.getIngredientId());
        dishIngredient.setQuantity(requestDto.getQuantity());
        dishIngredient.setUnit(requestDto.getUnit());
        dishIngredient = dishIngredientRepository.save(dishIngredient);
        return mapToResponseDto(dishIngredient);
    }

    @Override
    public void deleteDishIngredient(Long id) {
        dishIngredientRepository.deleteById(id);
    }

    @Override
    public List<DishIngredientsResponseDto> getIngredientsByDish(Long dishId) {
        return dishIngredientRepository.findByDishId(dishId).stream()
                .map(this::mapToResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<DishIngredientsResponseDto> getDishesByIngredient(Long ingredientId) {
        return dishIngredientRepository.findByIngredientId(ingredientId).stream()
                .map(this::mapToResponseDto)
                .collect(Collectors.toList());
    }

    private DishIngredientsResponseDto mapToResponseDto(DishIngredient dishIngredient) {
        DishIngredientsResponseDto responseDto = new DishIngredientsResponseDto();
        responseDto.setId(dishIngredient.getId());
        responseDto.setDishId(dishIngredient.getDishId());
        responseDto.setIngredientId(dishIngredient.getIngredientId());
        responseDto.setQuantity(dishIngredient.getQuantity());
        responseDto.setUnit(dishIngredient.getUnit());
        responseDto.setCreatedAt(dishIngredient.getCreatedAt());
        responseDto.setUpdatedAt(dishIngredient.getUpdatedAt());
        return responseDto;
    }
}