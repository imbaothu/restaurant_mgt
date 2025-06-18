package com.example.SeftOrderingRestaurant.Dtos.Request;

import com.example.SeftOrderingRestaurant.Enums.IngredientStatus;
import lombok.Data;

@Data
public class IngredientRequestDto {
    private String name;
    private IngredientStatus status;
}