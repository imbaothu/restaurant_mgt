package com.example.SeftOrderingRestaurant.Dtos.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

/**
 * Data Transfer Object for reservation responses.
 * This DTO is used to return reservation information to the client.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationResponseDto {
    private Long reservationId;
    private Integer tableId;
    private Integer tableNumber;
    private String customerName;
    private String customerEmail;
    private String customerPhone;
    private LocalDateTime reservationDateTime;
    private LocalDateTime endDateTime;
    private Integer numberOfGuests;
    private String status;  // CONFIRMED, CANCELLED, COMPLETED, NO_SHOW
    private String specialRequests;
    private String notes;
    private String assignedStaffId;
    private String assignedStaffName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Boolean isWalkIn;
    private String source;  // PHONE, WEBSITE, APP, WALK_IN
} 