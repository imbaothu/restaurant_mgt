package com.example.SeftOrderingRestaurant.Enums;

/**
 * Enum representing the different states a payment can be in.
 */
public enum PaymentStatus {
    PENDING("Payment is pending processing"),
    PROCESSING("Payment is being processed"),
    SUCCESS("Payment was successful"),
    FAILED("Payment failed"),
    REFUNDED("Payment has been refunded"),
    PARTIALLY_REFUNDED("Payment has been partially refunded"),
    CANCELLED("Payment was cancelled"),
    EXPIRED("Payment request has expired"),
    DECLINED("Payment was declined by the payment processor"),
    DISPUTED("Payment is under dispute");

    private final String description;

    PaymentStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}