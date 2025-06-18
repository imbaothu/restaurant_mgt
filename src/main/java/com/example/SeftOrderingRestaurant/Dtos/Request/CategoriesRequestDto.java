
package com.example.SeftOrderingRestaurant.Dtos.Request;

import com.example.SeftOrderingRestaurant.Enums.CategoryStatus;
import lombok.*;


@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoriesRequestDto
{
    private String name;
    private String description;
    private String image;
    private CategoryStatus status;

}