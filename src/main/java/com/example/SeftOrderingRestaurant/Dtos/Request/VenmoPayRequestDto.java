package com.example.SeftOrderingRestaurant.Dtos.Request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object for handling Venmo payment requests.
 * This DTO is used to process payments through Venmo.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VenmoPayRequestDto {
    
    @NotNull(message = "Order ID is required")
    @Positive(message = "Order ID must be positive")
    private Integer orderId;
    
    @NotNull(message = "Amount is required")
    @Positive(message = "Amount must be positive")
    private Integer amount;
    
    @NotBlank(message = "Venmo username is required")
    private String venmoUsername;
    
    @Email(message = "Invalid email format")
    private String email;
    
    @NotBlank(message = "Payment note is required")
    private String paymentNote;
    
    @NotBlank(message = "Currency is required")
    private String currency = "USD";
    
    private String returnUrl;
    private String cancelUrl;
    
    private Boolean requestPhoneNumber = false;
    private Boolean requestEmail = false;
} 