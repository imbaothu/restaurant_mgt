package com.example.SeftOrderingRestaurant.Services.Impl;

import com.example.SeftOrderingRestaurant.Dtos.Request.CategoryRequestDto;
import com.example.SeftOrderingRestaurant.Dtos.Response.CategoryResponseDto;
import com.example.SeftOrderingRestaurant.Entities.Categories;
import com.example.SeftOrderingRestaurant.Enums.CategoryStatus;
import com.example.SeftOrderingRestaurant.Exceptions.ResourceAlreadyExistsException;
import com.example.SeftOrderingRestaurant.Exceptions.ResourceNotFoundException;
import com.example.SeftOrderingRestaurant.Repositories.CategoryRepository;
import com.example.SeftOrderingRestaurant.Services.Interfaces.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements ICategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public CategoryResponseDto createCategory(CategoryRequestDto requestDto) {
        // Check if category with the same name already exists
        if (categoryRepository.existsByName(requestDto.getName())) {
            throw new ResourceAlreadyExistsException("Category with name " + requestDto.getName() + " already exists");
        }

        // Create and save new category
        Categories category = new Categories();
        BeanUtils.copyProperties(requestDto, category);
        Categories savedCategory = categoryRepository.save(category);

        // Convert to response dto and return
        return mapToResponseDto(savedCategory);
    }

    @Override
    public CategoryResponseDto getCategoryById(Integer id) {
        Categories category = getCategoryEntityById(id);
        return mapToResponseDto(category);
    }

    @Override
    public List<CategoryResponseDto> getAllCategories() {
        return categoryRepository.findAll()
                .stream()
                .map(this::mapToResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<CategoryResponseDto> getCategoriesByStatus(CategoryStatus status) {
        return categoryRepository.findByStatus(status)
                .stream()
                .map(this::mapToResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryResponseDto updateCategory(Integer id, CategoryRequestDto requestDto) {
        Categories category = getCategoryEntityById(id);

        // Check if updated name already exists for another category
        if (!category.getName().equals(requestDto.getName()) &&
                categoryRepository.existsByName(requestDto.getName())) {
            throw new ResourceAlreadyExistsException("Category with name " + requestDto.getName() + " already exists");
        }

        // Update category
        category.setName(requestDto.getName());
        category.setDescription(requestDto.getDescription());
        category.setImage(requestDto.getImage());
        if (requestDto.getStatus() != null) {
            category.setStatus(requestDto.getStatus());
        }

        Categories updatedCategory = categoryRepository.save(category);
        return mapToResponseDto(updatedCategory);
    }

    @Override
    public void deleteCategory(Integer id) {
        Categories category = getCategoryEntityById(id);
        categoryRepository.delete(category);
    }

    @Override
    public CategoryResponseDto updateCategoryStatus(Integer id, CategoryStatus status) {
        Categories category = getCategoryEntityById(id);
        category.setStatus(status);
        Categories updatedCategory = categoryRepository.save(category);
        return mapToResponseDto(updatedCategory);
    }

    // Helper method to get category entity by id
    private Categories getCategoryEntityById(Integer id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found with id: " + id));
    }

    // Helper method to map entity to response dto
    private CategoryResponseDto mapToResponseDto(Categories category) {
        CategoryResponseDto responseDto = new CategoryResponseDto();
        BeanUtils.copyProperties(category, responseDto);
        return responseDto;
    }
}
