
package com.example.SeftOrderingRestaurant.Dtos.Response;

import com.example.SeftOrderingRestaurant.Enums.DishStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.math.BigDecimal;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DishesResponseDto {
    private Integer dishId;
    private String dishName;
    private BigDecimal price;
    private DishStatus status;
    private String imageUrl;
    private String description;
    private String categoryName;
}