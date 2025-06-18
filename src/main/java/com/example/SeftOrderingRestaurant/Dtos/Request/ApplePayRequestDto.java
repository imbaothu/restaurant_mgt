package com.example.SeftOrderingRestaurant.Dtos.Request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object for handling Apple Pay payment requests.
 * This DTO is used to process payments through Apple Pay.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplePayRequestDto {
    
    @NotNull(message = "Order ID is required")
    @Positive(message = "Order ID must be positive")
    private Integer orderId;
    
    @NotNull(message = "Amount is required")
    @Positive(message = "Amount must be positive")
    private Integer amount;
    
    @NotBlank(message = "Apple Pay token is required")
    private String applePayToken;
    
    @NotBlank(message = "Payment method ID is required")
    private String paymentMethodId;
    
    private String billingAddress;
    private String shippingAddress;
    
    @NotBlank(message = "Currency is required")
    private String currency = "USD";
    
    private String merchantIdentifier;
    private String merchantName;
} 