package com.example.SeftOrderingRestaurant.Dtos.Response;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * Data Transfer Object for notification responses.
 * This DTO is used to return notification information to the client.
 */
@Data
public class NotificationResponseDto {
    private Long id;
    private Long userId;
    private String title;
    private String message;
    private String type;  // ORDER, RESERVATION, PAYMENT, SYSTEM
    private boolean read;
    private String link;
    private String priority;  // HIGH, MEDIUM, LOW
    private LocalDateTime createdAt;
    private LocalDateTime readAt;
} 