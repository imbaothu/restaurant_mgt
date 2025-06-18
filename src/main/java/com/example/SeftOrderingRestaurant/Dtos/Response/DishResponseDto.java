package com.example.SeftOrderingRestaurant.Dtos.Response;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * Data Transfer Object for dish responses.
 */
@Data
public class DishResponseDto {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Long categoryId;
    private String categoryName;
    private boolean available;
    private String imageUrl;
    private String preparationTime;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
} 