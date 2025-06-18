package com.example.SeftOrderingRestaurant.Dtos.Response;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Data Transfer Object for order item responses.
 */
@Data
public class OrderItemResponseDto {
    private Long id;
    private Long orderId;
    private Long dishId;
    private String dishName;
    private Integer quantity;
    private Double price;
    private String specialInstructions;
    private List<String> customizations;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
} 