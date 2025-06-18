package com.example.SeftOrderingRestaurant.Dtos.Request;

import com.example.SeftOrderingRestaurant.Enums.TableStatus;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object for handling table management requests.
 * This DTO is used to create and update restaurant tables.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TableRequestDto {
    
    @NotNull(message = "Table number is required")
    @Positive(message = "Table number must be positive")
    private Integer tableNumber;

    @NotNull(message = "Capacity is required")
    @Positive(message = "Capacity must be at least 1")
    private Integer capacity;

    @NotNull(message = "Table status is required")
    private TableStatus tableStatus;

    @Size(max = 100, message = "Location description cannot exceed 100 characters")
    private String location;
    
    private String qrCode;
    
    private Boolean isReservable = true;
    
    private String section;
    
    @Size(max = 500, message = "Notes cannot exceed 500 characters")
    private String notes;
} 