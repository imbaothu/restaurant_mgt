package com.example.SeftOrderingRestaurant.Enums;

/**
 * Enum representing different types of notifications in the system.
 */
public enum NotificationType {
    ORDER_STATUS("Notification about order status changes"),
    TABLE_REQUEST("Notification about table reservation requests"),
    PAYMENT_STATUS("Notification about payment status updates"),
    RESERVATION_STATUS("Notification about reservation status changes"),
    INVENTORY_ALERT("Notification about inventory levels"),
    STAFF_SCHEDULE("Notification about staff schedule changes"),
    SYSTEM_MAINTENANCE("System maintenance notifications"),
    PROMOTION("Promotional notifications"),
    FEEDBACK_REQUEST("Customer feedback request notifications"),
    LOYALTY_REWARDS("Loyalty program notifications");

    private final String description;

    NotificationType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}