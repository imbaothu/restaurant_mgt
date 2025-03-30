package com.example.SeftOrderingRestaurant.Services.Interfaces;
import com.example.SeftOrderingRestaurant.Dtos.Request.CategoryRequestDto;
import com.example.SeftOrderingRestaurant.Dtos.Response.CategoryResponseDto;
import com.example.SeftOrderingRestaurant.Enums.CategoryStatus;

import java.util.List;

public interface ICategoryService {

    CategoryResponseDto createCategory(CategoryRequestDto requestDto);

    CategoryResponseDto getCategoryById(Integer id);

    List<CategoryResponseDto> getAllCategories();

    List<CategoryResponseDto> getCategoriesByStatus(CategoryStatus status);

    CategoryResponseDto updateCategory(Integer id, CategoryRequestDto requestDto);

    void deleteCategory(Integer id);

    CategoryResponseDto updateCategoryStatus(Integer id, CategoryStatus status);
}
