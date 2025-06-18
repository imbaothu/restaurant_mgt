package com.example.SeftOrderingRestaurant.Dtos.Request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * Data Transfer Object for inventory creation and update requests.
 */
@Data
public class InventoryRequestDto {
    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    private String name;

    @NotBlank(message = "Category is required")
    private String category;

    @NotNull(message = "Quantity is required")
    @Min(value = 0, message = "Quantity cannot be negative")
    private Integer quantity;

    @NotNull(message = "Unit price is required")
    @Positive(message = "Unit price must be greater than 0")
    private Double unitPrice;

    @Size(max = 200, message = "Unit cannot exceed 200 characters")
    private String unit;

    @Size(max = 500, message = "Description cannot exceed 500 characters")
    private String description;

    @NotNull(message = "Supplier ID is required")
    private Long supplierId;

    @Min(value = 0, message = "Minimum quantity cannot be negative")
    private Integer minimumQuantity;

    @Size(max = 200, message = "Location cannot exceed 200 characters")
    private String location;
}