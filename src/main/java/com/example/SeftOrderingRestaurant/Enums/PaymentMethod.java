package com.example.SeftOrderingRestaurant.Enums;

/**
 * Enum representing different payment methods available in the system.
 */
public enum PaymentMethod {
    CASH,
    CREDIT_CARD,
    DEBIT_CARD,
    MOBILE_PAYMENT,
    APPLE_PAY("Apple Pay mobile payment"),
    GOOGLE_PAY("Google Pay mobile payment"),
    VENMO("Venmo payment"),
    PAYPAL("PayPal payment"),
    GIFT_CARD("Gift card payment"),
    LOYALTY_POINTS("Loyalty points redemption");

    private final String description;

    PaymentMethod(String description) {
        this.description = description;
    }

    PaymentMethod() {
        this.description = null;
    }

    public String getDescription() {
        return description;
    }
}
