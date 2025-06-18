package com.example.SeftOrderingRestaurant.Dtos.Request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Data Transfer Object for handling menu item customization requests.
 * This DTO is used to manage customizations for menu items in orders.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuItemCustomizationRequestDto {
    
    @NotNull(message = "Menu item ID is required")
    @Positive(message = "Menu item ID must be positive")
    private Integer menuItemId;
    
    @Size(max = 10, message = "Cannot add more than 10 customizations")
    private List<IngredientCustomization> additions;
    
    @Size(max = 10, message = "Cannot remove more than 10 ingredients")
    private List<IngredientCustomization> removals;
    
    private String specialInstructions;
    
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class IngredientCustomization {
        @NotNull(message = "Ingredient ID is required")
        @Positive(message = "Ingredient ID must be positive")
        private Integer ingredientId;
        
        @NotNull(message = "Quantity is required")
        @Positive(message = "Quantity must be positive")
        private Integer quantity;
    }
} 