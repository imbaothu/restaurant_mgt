package com.example.SeftOrderingRestaurant.Service.Impl;

import com.example.SeftOrderingRestaurant.Dtos.Request.CategoryRequestDto;
import com.example.SeftOrderingRestaurant.Dtos.Response.CategoryResponseDto;
import com.example.SeftOrderingRestaurant.Service.Interfaces.ICategoriesService;
import com.example.SeftOrderingRestaurant.Entities.Categories;
import com.example.SeftOrderingRestaurant.Repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class CategoriesServiceImpl implements ICategoriesService {

    private final CategoryRepository categoryRepository;

    @Override
    public CategoryResponseDto createCategory(CategoryRequestDto requestDto) {
        Categories category = new Categories();
        category.setName(requestDto.getName());
        category.setDescription(requestDto.getDescription());
        category.setType(requestDto.getType());
        category = categoryRepository.save(category);
        return mapToResponseDto(category);
    }

    @Override
    public CategoryResponseDto getCategoryById(Long id) {
        Categories category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        return mapToResponseDto(category);
    }

    @Override
    public List<CategoryResponseDto> getAllCategories() {
        return categoryRepository.findAll().stream()
                .map(this::mapToResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryResponseDto updateCategory(Long id, CategoryRequestDto requestDto) {
        Categories category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        category.setName(requestDto.getName());
        category.setDescription(requestDto.getDescription());
        category.setType(requestDto.getType());
        category = categoryRepository.save(category);
        return mapToResponseDto(category);
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public List<CategoryResponseDto> getCategoriesByType(String type) {
        return categoryRepository.findAll().stream()
                .filter(category -> category.getType().equals(type))
                .map(this::mapToResponseDto)
                .collect(Collectors.toList());
    }

    private CategoryResponseDto mapToResponseDto(Categories category) {
        CategoryResponseDto responseDto = new CategoryResponseDto();
        responseDto.setId(category.getId());
        responseDto.setName(category.getName());
        responseDto.setDescription(category.getDescription());
        responseDto.setType(category.getType());
        responseDto.setCreatedAt(category.getCreatedAt());
        responseDto.setUpdatedAt(category.getUpdatedAt());
        return responseDto;
    }
}