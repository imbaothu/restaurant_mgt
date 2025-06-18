package com.example.SeftOrderingRestaurant.Dtos.Request;

import com.example.SeftOrderingRestaurant.Enums.DishStatus;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;

/**
 * Data Transfer Object for handling dish creation and update requests.
 * This DTO is used to transfer dish data between the client and server.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DishesRequestDto {
    
    @NotBlank(message = "Dish name is required")
    @Size(min = 2, max = 100, message = "Dish name must be between 2 and 100 characters")
    private String name;
    
    @NotNull(message = "Price is required")
    @Positive(message = "Price must be positive")
    private BigDecimal price;
    
    @NotNull(message = "Category ID is required")
    @Positive(message = "Category ID must be positive")
    private Integer categoryId;
    
    @Size(max = 500, message = "Description cannot exceed 500 characters")
    private String description;
    
    private MultipartFile image;
    
    @NotNull(message = "Dish status is required")
    private DishStatus status;
}