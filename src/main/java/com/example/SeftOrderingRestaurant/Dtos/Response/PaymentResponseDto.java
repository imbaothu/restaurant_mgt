/* *****************************************
 * CSCI 205 - Software Engineering and Design
 * Fall 2024
 * Instructor: Prof. Lily
 *
 * Name: Thu Le
 * Section: YOUR SECTION
 * Date: 10/06/2025
 * Time: 16:24
 *
 * Project: restaurant_mgt
 * Package: com.example.SeftOrderingRestaurant.Dtos.Response
 * Class: PaymentResponseDto
 *
 * Description:
 *
 * ****************************************
 */
package com.example.SeftOrderingRestaurant.Dtos.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

/**
 * Data Transfer Object for payment responses.
 * This DTO is used to return payment processing results to the client.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentResponseDto {
    private String paymentId;
    private String status;
    private String paymentMethod;
    private Integer amount;
    private String currency;
    private LocalDateTime timestamp;
    private String transactionId;
    private String errorMessage;
    private Boolean success;
    
    // Additional fields for specific payment methods
    private String applePayToken;  // For Apple Pay
    private String venmoUsername;  // For Venmo
    private String receiptUrl;     // For payment receipts
    private String refundId;       // For refunds
}