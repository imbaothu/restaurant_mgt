package com.example.SeftOrderingRestaurant.Controllers;

import com.example.SeftOrderingRestaurant.Dtos.Request.CategoryRequestDto;
import com.example.SeftOrderingRestaurant.Dtos.Response.CategoryResponseDto;
import com.example.SeftOrderingRestaurant.Enums.CategoryStatus;
import com.example.SeftOrderingRestaurant.Services.Interfaces.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final ICategoryService categoryService;

    @PostMapping
    public ResponseEntity<CategoryResponseDto> createCategory(@Valid @RequestBody CategoryRequestDto requestDto) {
        return new ResponseEntity<>(categoryService.createCategory(requestDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponseDto> getCategoryById(@PathVariable Integer id) {
        return ResponseEntity.ok(categoryService.getCategoryById(id));
    }

    @GetMapping
    public ResponseEntity<List<CategoryResponseDto>> getAllCategories(
            @RequestParam(required = false) CategoryStatus status) {
        if (status != null) {
            return ResponseEntity.ok(categoryService.getCategoriesByStatus(status));
        }
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponseDto> updateCategory(
            @PathVariable Integer id,
            @Valid @RequestBody CategoryRequestDto requestDto) {
        return ResponseEntity.ok(categoryService.updateCategory(id, requestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Integer id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<CategoryResponseDto> updateCategoryStatus(
            @PathVariable Integer id,
            @RequestParam CategoryStatus status) {
        return ResponseEntity.ok(categoryService.updateCategoryStatus(id, status));
    }
}
