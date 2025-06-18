package com.example.SeftOrderingRestaurant.Service.Impl;

import com.example.SeftOrderingRestaurant.Dtos.Request.IngredientRequestDto;
import com.example.SeftOrderingRestaurant.Dtos.Response.IngredientResponseDto;
import com.example.SeftOrderingRestaurant.Service.Interfaces.IIngredientsService;
import com.example.SeftOrderingRestaurant.Entities.Ingredient;
import com.example.SeftOrderingRestaurant.Repositories.IngredientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class IngredientsServiceImpl implements IIngredientsService {

    private final IngredientRepository ingredientRepository;

    @Override
    public IngredientResponseDto createIngredient(IngredientRequestDto requestDto) {
        Ingredient ingredient = new Ingredient();
        ingredient.setName(requestDto.getName());
        ingredient.setCategory(requestDto.getCategory());
        ingredient.setQuantity(requestDto.getQuantity());
        ingredient.setUnitPrice(requestDto.getUnitPrice());
        ingredient.setUnit(requestDto.getUnit());
        ingredient.setDescription(requestDto.getDescription());
        ingredient.setSupplierId(requestDto.getSupplierId());
        ingredient.setMinimumQuantity(requestDto.getMinimumQuantity());
        ingredient.setLocation(requestDto.getLocation());
        ingredient = ingredientRepository.save(ingredient);
        return mapToResponseDto(ingredient);
    }

    @Override
    public IngredientResponseDto getIngredientById(Long id) {
        Ingredient ingredient = ingredientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ingredient not found"));
        return mapToResponseDto(ingredient);
    }

    @Override
    public List<IngredientResponseDto> getAllIngredients() {
        return ingredientRepository.findAll().stream()
                .map(this::mapToResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public IngredientResponseDto updateIngredient(Long id, IngredientRequestDto requestDto) {
        Ingredient ingredient = ingredientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ingredient not found"));
        ingredient.setName(requestDto.getName());
        ingredient.setCategory(requestDto.getCategory());
        ingredient.setQuantity(requestDto.getQuantity());
        ingredient.setUnitPrice(requestDto.getUnitPrice());
        ingredient.setUnit(requestDto.getUnit());
        ingredient.setDescription(requestDto.getDescription());
        ingredient.setSupplierId(requestDto.getSupplierId());
        ingredient.setMinimumQuantity(requestDto.getMinimumQuantity());
        ingredient.setLocation(requestDto.getLocation());
        ingredient = ingredientRepository.save(ingredient);
        return mapToResponseDto(ingredient);
    }

    @Override
    public void deleteIngredient(Long id) {
        ingredientRepository.deleteById(id);
    }

    @Override
    public List<IngredientResponseDto> getIngredientsByCategory(String category) {
        return ingredientRepository.findByCategory(category).stream()
                .map(this::mapToResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<IngredientResponseDto> getIngredientsBySupplier(Long supplierId) {
        return ingredientRepository.findBySupplierId(supplierId).stream()
                .map(this::mapToResponseDto)
                .collect(Collectors.toList());
    }

    private IngredientResponseDto mapToResponseDto(Ingredient ingredient) {
        IngredientResponseDto responseDto = new IngredientResponseDto();
        responseDto.setId(ingredient.getId());
        responseDto.setName(ingredient.getName());
        responseDto.setCategory(ingredient.getCategory());
        responseDto.setQuantity(ingredient.getQuantity());
        responseDto.setUnitPrice(ingredient.getUnitPrice());
        responseDto.setUnit(ingredient.getUnit());
        responseDto.setDescription(ingredient.getDescription());
        responseDto.setSupplierId(ingredient.getSupplierId());
        responseDto.setMinimumQuantity(ingredient.getMinimumQuantity());
        responseDto.setLocation(ingredient.getLocation());
        responseDto.setCreatedAt(ingredient.getCreatedAt());
        responseDto.setUpdatedAt(ingredient.getUpdatedAt());
        responseDto.setLastRestockedAt(ingredient.getLastRestockedAt());
        return responseDto;
    }
}