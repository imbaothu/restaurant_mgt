package com.example.SeftOrderingRestaurant.Enums;

/**
 * Enum representing different types of users in the system.
 */
public enum UserType {
    ADMIN("System administrator with full access"),
    MANAGER("Restaurant manager with management privileges"),
    STAFF("Restaurant staff member"),
    CUSTOMER("Regular customer"),
    SUPPLIER("Supplier or vendor"),
    DELIVERY_PARTNER("Delivery service partner"),
    GUEST("Temporary guest user");

    private final String description;

    UserType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}