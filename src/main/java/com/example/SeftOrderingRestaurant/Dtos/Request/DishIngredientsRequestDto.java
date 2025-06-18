package com.example.SeftOrderingRestaurant.Dtos.Request;

import com.example.SeftOrderingRestaurant.Enums.IngredientStatus;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Min;
import java.math.BigDecimal;

/**
 * Data Transfer Object for handling dish ingredient requests.
 * This DTO is used to transfer ingredient data between the client and server.
 */
@Getter
@Setter
public class DishIngredientsRequestDto {
    
    @NotNull(message = "Dish ID is required")
    private Long dishId;
    
    @NotNull(message = "Ingredient ID is required")
    private Long ingredientId;
    
    @NotNull(message = "Quantity is required")
    @Positive(message = "Quantity must be positive")
    private Double quantity;
    
    @NotNull(message = "Unit is required")
    private String unit;
}