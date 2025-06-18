package com.example.SeftOrderingRestaurant.Dtos.Request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Data Transfer Object for handling table reservation requests.
 * This DTO is used to manage restaurant table reservations.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationRequestDto {
    
    @NotNull(message = "Table ID is required")
    @Positive(message = "Table ID must be positive")
    private Integer tableId;
    
    @NotNull(message = "Reservation date and time is required")
    @Future(message = "Reservation must be in the future")
    private LocalDateTime reservationDateTime;
    
    @NotNull(message = "Number of guests is required")
    @Min(value = 1, message = "Minimum 1 guest required")
    @Max(value = 20, message = "Maximum 20 guests allowed")
    private Integer numberOfGuests;
    
    @NotNull(message = "Customer name is required")
    private String customerName;
    
    @Email(message = "Invalid email format")
    private String email;
    
    @Pattern(regexp = "^\\+?[1-9]\\d{1,14}$", message = "Invalid phone number format")
    private String phone;
    
    private String specialRequests;
    
    @NotNull(message = "Duration is required")
    @Min(value = 30, message = "Minimum reservation duration is 30 minutes")
    @Max(value = 240, message = "Maximum reservation duration is 4 hours")
    private Integer durationMinutes;
} 