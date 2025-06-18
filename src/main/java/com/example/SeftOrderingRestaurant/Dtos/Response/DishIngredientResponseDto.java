
package com.example.SeftOrderingRestaurant.Dtos.Response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class DishIngredientResponseDto {
    private Integer dishId;
    private Integer ingredientId;
    private BigDecimal quantity;

}