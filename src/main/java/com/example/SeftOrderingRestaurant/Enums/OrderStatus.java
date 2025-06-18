package com.example.SeftOrderingRestaurant.Enums;

/**
 * Enum representing the different states an order can be in.
 */
public enum OrderStatus {
    PENDING("Order has been placed but not yet confirmed"),
    CONFIRMED("Order has been confirmed by the restaurant"),
    PREPARING("Order is being prepared in the kitchen"),
    READY("Order is ready for pickup/delivery"),
    OUT_FOR_DELIVERY("Order is being delivered"),
    DELIVERED("Order has been delivered"),
    COMPLETED("Order has been completed and paid"),
    CANCELLED("Order has been cancelled"),
    REFUNDED("Order has been refunded"),
    ON_HOLD("Order is temporarily on hold");

    private final String description;

    OrderStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}