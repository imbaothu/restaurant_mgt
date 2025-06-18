package com.example.SeftOrderingRestaurant.Service.Impl;

import com.example.SeftOrderingRestaurant.Service.Interfaces.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String fromEmail;

    @Override
    public void sendPasswordResetEmail(String email, String otp) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(fromEmail);
        message.setTo(email);
        message.setSubject("Password Reset Request");
        message.setText(String.format(
            "Your password reset OTP is: %s\n\n" +
            "This OTP will expire in 10 minutes.\n" +
            "If you did not request this password reset, please ignore this email.",
            otp
        ));
        mailSender.send(message);
        log.info("Password reset email sent to: {}", email);
    }

    @Override
    public void sendWelcomeEmail(String email, String username) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(fromEmail);
        message.setTo(email);
        message.setSubject("Welcome to Our Restaurant!");
        message.setText(String.format(
            "Dear %s,\n\n" +
            "Welcome to our restaurant management system!\n" +
            "We're excited to have you on board.\n\n" +
            "Best regards,\n" +
            "The Restaurant Team",
            username
        ));
        mailSender.send(message);
        log.info("Welcome email sent to: {}", email);
    }

    @Override
    public void sendOrderConfirmationEmail(String email, Long orderId, String orderDetails) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(fromEmail);
        message.setTo(email);
        message.setSubject("Order Confirmation - Order #" + orderId);
        message.setText(String.format(
            "Thank you for your order!\n\n" +
            "Order ID: %d\n\n" +
            "Order Details:\n%s\n\n" +
            "We'll notify you when your order is ready.\n\n" +
            "Best regards,\n" +
            "The Restaurant Team",
            orderId, orderDetails
        ));
        mailSender.send(message);
        log.info("Order confirmation email sent to: {}", email);
    }

    @Override
    public void sendReservationConfirmationEmail(String email, Long reservationId, String reservationDetails) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(fromEmail);
        message.setTo(email);
        message.setSubject("Reservation Confirmation - Reservation #" + reservationId);
        message.setText(String.format(
            "Thank you for your reservation!\n\n" +
            "Reservation ID: %d\n\n" +
            "Reservation Details:\n%s\n\n" +
            "We look forward to serving you!\n\n" +
            "Best regards,\n" +
            "The Restaurant Team",
            reservationId, reservationDetails
        ));
        mailSender.send(message);
        log.info("Reservation confirmation email sent to: {}", email);
    }
} 