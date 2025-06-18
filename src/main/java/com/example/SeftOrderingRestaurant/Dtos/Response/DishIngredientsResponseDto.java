package com.example.SeftOrderingRestaurant.Dtos.Response;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class DishIngredientsResponseDto {
    private Long id;
    private Long dishId;
    private Long ingredientId;
    private Double quantity;
    private String unit;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
} 