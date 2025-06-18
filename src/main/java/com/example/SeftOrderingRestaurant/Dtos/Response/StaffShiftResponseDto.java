package com.example.SeftOrderingRestaurant.Dtos.Response;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class StaffShiftResponseDto {
    private Long id;
    private Long staffId;
    private Long shiftId;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
} 