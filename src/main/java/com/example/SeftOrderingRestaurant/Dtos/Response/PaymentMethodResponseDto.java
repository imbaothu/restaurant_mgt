package com.example.SeftOrderingRestaurant.Dtos.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

/**
 * Data Transfer Object for payment method-specific responses.
 * This DTO is used to return payment method-specific details to the client.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentMethodResponseDto {
    private String methodId;
    private String methodType;  // APPLE_PAY, VENMO, etc.
    private String status;
    private LocalDateTime lastUsed;
    private Boolean isDefault;
    private String displayName;
    private String maskedDetails;  // e.g., "****1234" for cards
    private String expiryDate;     // For cards
    private String brand;          // For cards (Visa, Mastercard, etc.)
    private String network;        // For digital wallets
    private Boolean isEnabled;
} 