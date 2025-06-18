package com.example.SeftOrderingRestaurant.Dtos.Response;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * Data Transfer Object for category responses.
 */
@Data
public class CategoryResponseDto {
    private Long id;
    private String name;
    private String description;
    private String type;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
} 