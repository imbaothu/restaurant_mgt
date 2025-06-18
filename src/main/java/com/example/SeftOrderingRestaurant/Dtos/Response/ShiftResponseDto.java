/* *****************************************
 * CSCI 205 - Software Engineering and Design
 * Fall 2024
 * Instructor: Prof. Lily
 *
 * Name: Thu Le
 * Section: YOUR SECTION
 * Date: 10/06/2025
 * Time: 16:30
 *
 * Project: restaurant_mgt
 * Package: com.example.SeftOrderingRestaurant.Dtos.Response
 * Class: ShiftResponseDto
 *
 * Description:
 *
 * ****************************************
 */
package com.example.SeftOrderingRestaurant.Dtos.Response;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Data Transfer Object for shift responses.
 */
@Data
public class ShiftResponseDto {
    private Long id;
    private String startTime;
    private String endTime;
    private String date;
    private String type;
    private String notes;
    private Integer maxStaffCount;
    private boolean active;
    private List<Long> assignedStaffIds;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}