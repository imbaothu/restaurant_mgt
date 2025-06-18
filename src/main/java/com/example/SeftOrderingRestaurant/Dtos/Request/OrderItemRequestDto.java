package com.example.SeftOrderingRestaurant.Dtos.Request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import java.util.List;

/**
 * Data Transfer Object for order item creation and update requests.
 */
@Data
public class OrderItemRequestDto {
    @NotNull(message = "Order ID is required")
    private Long orderId;

    @NotNull(message = "Dish ID is required")
    private Long dishId;

    @NotNull(message = "Quantity is required")
    @Min(value = 1, message = "Quantity must be at least 1")
    private Integer quantity;

    @Size(max = 500, message = "Special instructions cannot exceed 500 characters")
    private String specialInstructions;

    private List<Long> customizationIds;

    private String status = "PENDING";
} 