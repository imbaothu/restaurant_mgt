package com.example.SeftOrderingRestaurant.Dtos.Response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
public class IngredientResponseDto {
    private Long id;
    private String name;
    private String category;
    private Double quantity;
    private Double unitPrice;
    private String unit;
    private String description;
    private Long supplierId;
    private Integer minimumQuantity;
    private String location;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime lastRestockedAt;
} 