package com.example.SeftOrderingRestaurant.Dtos.Request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Data Transfer Object for handling customer feedback requests.
 * This DTO is used to collect and process customer feedback for orders.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerFeedbackRequestDto {
    
    @NotNull(message = "Customer ID is required")
    @Positive(message = "Customer ID must be positive")
    private Integer customerId;
    
    @NotNull(message = "Order ID is required")
    @Positive(message = "Order ID must be positive")
    private Integer orderId;
    
    @NotNull(message = "Rating is required")
    @Min(value = 1, message = "Rating must be at least 1")
    @Max(value = 5, message = "Rating cannot exceed 5")
    private Integer rating;
    
    @Size(max = 1000, message = "Feedback cannot exceed 1000 characters")
    private String feedback;
    
    @Size(max = 10, message = "Cannot select more than 10 tags")
    private List<@Size(max = 50, message = "Tag cannot exceed 50 characters") String> selectedTags;
}