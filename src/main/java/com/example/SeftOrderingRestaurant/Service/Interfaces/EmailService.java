package com.example.SeftOrderingRestaurant.Service.Interfaces;

/**
 * Service interface for handling email-related operations.
 */
public interface EmailService {
    /**
     * Send a password reset email to the user.
     *
     * @param email The recipient's email address
     * @param otp The one-time password for reset
     */
    void sendPasswordResetEmail(String email, String otp);

    /**
     * Send a welcome email to a new user.
     *
     * @param email The recipient's email address
     * @param username The username of the new user
     */
    void sendWelcomeEmail(String email, String username);

    /**
     * Send an order confirmation email.
     *
     * @param email The recipient's email address
     * @param orderId The ID of the order
     * @param orderDetails The details of the order
     */
    void sendOrderConfirmationEmail(String email, Long orderId, String orderDetails);

    /**
     * Send a reservation confirmation email.
     *
     * @param email The recipient's email address
     * @param reservationId The ID of the reservation
     * @param reservationDetails The details of the reservation
     */
    void sendReservationConfirmationEmail(String email, Long reservationId, String reservationDetails);
} 