
package com.example.SeftOrderingRestaurant.Service.Impl;

import com.example.SeftOrderingRestaurant.Dtos.Request.DishRequestDto;
import com.example.SeftOrderingRestaurant.Dtos.Response.DishResponseDto;
import com.example.SeftOrderingRestaurant.Service.Interfaces.IDishesService;
import com.example.SeftOrderingRestaurant.Entities.Dish;
import com.example.SeftOrderingRestaurant.Repositories.DishRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class DishesServiceImpl implements IDishesService {

    private final DishRepository dishRepository;

    @Override
    public DishResponseDto createDish(DishRequestDto requestDto) {
        Dish dish = new Dish();
        dish.setName(requestDto.getName());
        dish.setDescription(requestDto.getDescription());
        dish.setPrice(requestDto.getPrice());
        dish.setCategoryId(requestDto.getCategoryId());
        dish.setImageUrl(requestDto.getImageUrl());
        dish.setAvailable(requestDto.isAvailable());
        dish = dishRepository.save(dish);
        return mapToResponseDto(dish);
    }

    @Override
    public DishResponseDto getDishById(Long id) {
        Dish dish = dishRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dish not found"));
        return mapToResponseDto(dish);
    }

    @Override
    public List<DishResponseDto> getAllDishes() {
        return dishRepository.findAll().stream()
                .map(this::mapToResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public DishResponseDto updateDish(Long id, DishRequestDto requestDto) {
        Dish dish = dishRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dish not found"));
        dish.setName(requestDto.getName());
        dish.setDescription(requestDto.getDescription());
        dish.setPrice(requestDto.getPrice());
        dish.setCategoryId(requestDto.getCategoryId());
        dish.setImageUrl(requestDto.getImageUrl());
        dish.setAvailable(requestDto.isAvailable());
        dish = dishRepository.save(dish);
        return mapToResponseDto(dish);
    }

    @Override
    public void deleteDish(Long id) {
        dishRepository.deleteById(id);
    }

    @Override
    public List<DishResponseDto> getDishesByCategory(Long categoryId) {
        return dishRepository.findByCategoryId(categoryId).stream()
                .map(this::mapToResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<DishResponseDto> getAvailableDishes() {
        return dishRepository.findByAvailableTrue().stream()
                .map(this::mapToResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public DishResponseDto updateDishAvailability(Long id, boolean available) {
        Dish dish = dishRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dish not found"));
        dish.setAvailable(available);
        dish = dishRepository.save(dish);
        return mapToResponseDto(dish);
    }

    @Override
    public List<DishResponseDto> getDishesByPriceRange(Double minPrice, Double maxPrice) {
        return dishRepository.findAll().stream()
                .filter(dish -> dish.getPrice() >= minPrice && dish.getPrice() <= maxPrice)
                .map(this::mapToResponseDto)
                .collect(Collectors.toList());
    }

    private DishResponseDto mapToResponseDto(Dish dish) {
        DishResponseDto responseDto = new DishResponseDto();
        responseDto.setId(dish.getId());
        responseDto.setName(dish.getName());
        responseDto.setDescription(dish.getDescription());
        responseDto.setPrice(dish.getPrice());
        responseDto.setCategoryId(dish.getCategoryId());
        responseDto.setImageUrl(dish.getImageUrl());
        responseDto.setAvailable(dish.isAvailable());
        responseDto.setCreatedAt(dish.getCreatedAt());
        responseDto.setUpdatedAt(dish.getUpdatedAt());
        return responseDto;
    }
}