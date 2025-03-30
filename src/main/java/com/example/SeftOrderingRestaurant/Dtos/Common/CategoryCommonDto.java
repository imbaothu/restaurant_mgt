package com.example.SeftOrderingRestaurant.Dtos.Common;

import com.example.SeftOrderingRestaurant.Enums.CategoryStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryCommonDto {

    private Integer id;
    private String name;
    private String description;
    private String image;
    private CategoryStatus status;
}