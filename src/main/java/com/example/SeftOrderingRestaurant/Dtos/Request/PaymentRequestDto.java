package com.example.SeftOrderingRestaurant.Dtos.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * Data Transfer Object for payment creation and update requests.
 */
@Data
public class PaymentRequestDto {
    @NotNull(message = "Order ID is required")
    private Long orderId;

    @NotNull(message = "Amount is required")
    @Positive(message = "Amount must be greater than 0")
    private Double amount;

    @NotBlank(message = "Payment method is required")
    private String paymentMethod;

    @Size(max = 200, message = "Transaction ID cannot exceed 200 characters")
    private String transactionId;

    @Size(max = 500, message = "Notes cannot exceed 500 characters")
    private String notes;

    private boolean refunded = false;
} 