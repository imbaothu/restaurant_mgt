package com.example.SeftOrderingRestaurant.Dtos.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * Data Transfer Object for shift creation and update requests.
 */
@Data
public class ShiftRequestDto {
    @NotBlank(message = "Start time is required")
    private String startTime;

    @NotBlank(message = "End time is required")
    private String endTime;

    @NotBlank(message = "Date is required")
    private String date;

    @NotBlank(message = "Type is required")
    private String type;

    @Size(max = 200, message = "Notes cannot exceed 200 characters")
    private String notes;

    @NotNull(message = "Maximum staff count is required")
    private Integer maxStaffCount;

    private boolean active = true;
}