package com.example.SeftOrderingRestaurant.Dtos.Response;

import com.example.SeftOrderingRestaurant.Enums.CategoryStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryResponseDto {

    private Integer id;
    private String name;
    private String description;
    private String image;
    private CategoryStatus status;
}
