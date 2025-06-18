package com.example.SeftOrderingRestaurant.Enums;

/**
 * Enum representing the different states a restaurant table can be in.
 */
public enum TableStatus {
    AVAILABLE("Table is available for seating"),
    OCCUPIED("Table is currently occupied by customers"),
    RESERVED("Table is reserved for future use"),
    CLEANING("Table is being cleaned"),
    OUT_OF_SERVICE("Table is temporarily out of service"),
    MAINTENANCE("Table is under maintenance");

    private final String description;

    TableStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
