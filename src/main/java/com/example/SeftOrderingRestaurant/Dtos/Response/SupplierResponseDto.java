package com.example.SeftOrderingRestaurant.Dtos.Response;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * Data Transfer Object for supplier responses.
 */
@Data
public class SupplierResponseDto {
    private Long id;
    private String companyName;
    private String contactPerson;
    private String email;
    private String phoneNumber;
    private String category;
    private boolean active;
    private String address;
    private String website;
    private String notes;
    private Double rating;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
} 