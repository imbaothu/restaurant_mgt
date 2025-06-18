package com.example.SeftOrderingRestaurant.Dtos.Request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Data Transfer Object for handling order creation requests.
 * This DTO is used to transfer order data between the client and server.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequestDto {
    
    @NotNull(message = "Customer ID is required")
    @Positive(message = "Customer ID must be positive")
    private Long customerId;

    @NotEmpty(message = "At least one dish must be ordered")
    @Size(min = 1, message = "At least one dish must be ordered")
    private List<Long> dishIds;

    @NotEmpty(message = "Quantities must be provided for each dish")
    @Size(min = 1, message = "At least one quantity must be provided")
    private List<@Positive(message = "Quantity must be positive") Integer> quantities;
}