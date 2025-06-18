package com.example.SeftOrderingRestaurant.Dtos.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * Data Transfer Object for notification creation requests.
 */
@Data
public class NotificationRequestDto {
    @NotNull(message = "User ID is required")
    private Long userId;

    @NotBlank(message = "Title is required")
    @Size(min = 2, max = 100, message = "Title must be between 2 and 100 characters")
    private String title;

    @NotBlank(message = "Message is required")
    @Size(min = 2, max = 500, message = "Message must be between 2 and 500 characters")
    private String message;

    @NotBlank(message = "Type is required")
    private String type;

    private boolean read = false;

    @Size(max = 200, message = "Link cannot exceed 200 characters")
    private String link;

    @Size(max = 50, message = "Priority cannot exceed 50 characters")
    private String priority;
}