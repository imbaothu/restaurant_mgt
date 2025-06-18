package com.example.SeftOrderingRestaurant.Dtos.Response;

import com.example.SeftOrderingRestaurant.Enums.TableStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Data Transfer Object for table responses.
 * This DTO is used to return table information to the client.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TableResponseDto {
    private Integer id;
    private Integer tableNumber;
    private Integer capacity;
    private TableStatus status;
    private String location;
    private String section;
    private Boolean isReservable;
    private String qrCode;
    private LocalDateTime lastOccupied;
    private Integer currentOrderId;
    private Integer notificationCount;
    private List<DishDto> currentOrderItems;
    private String notes;
} 