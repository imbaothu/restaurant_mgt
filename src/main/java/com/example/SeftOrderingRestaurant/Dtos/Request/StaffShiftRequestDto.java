package com.example.SeftOrderingRestaurant.Dtos.Request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class StaffShiftRequestDto {
    @NotNull(message = "Staff ID is required")
    private Long staffId;

    @NotNull(message = "Shift ID is required")
    private Long shiftId;

    @NotNull(message = "Status is required")
    private String status;
} 