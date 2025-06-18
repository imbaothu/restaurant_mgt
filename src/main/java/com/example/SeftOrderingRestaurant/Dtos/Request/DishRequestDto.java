package com.example.SeftOrderingRestaurant.Dtos.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * Data Transfer Object for dish creation and update requests.
 */
@Data
public class DishRequestDto {
    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    private String name;

    @Size(max = 500, message = "Description cannot exceed 500 characters")
    private String description;

    @NotNull(message = "Price is required")
    @Positive(message = "Price must be greater than 0")
    private Double price;

    @NotNull(message = "Category ID is required")
    private Long categoryId;

    private boolean available = true;

    @Size(max = 200, message = "Image URL cannot exceed 200 characters")
    private String imageUrl;

    @Size(max = 100, message = "Preparation time cannot exceed 100 characters")
    private String preparationTime;
} 