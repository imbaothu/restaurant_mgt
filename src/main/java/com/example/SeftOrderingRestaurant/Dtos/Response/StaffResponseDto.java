/* *****************************************
 * CSCI 205 - Software Engineering and Design
 * Fall 2024
 * Instructor: Prof. Lily
 *
 * Name: Thu Le
 * Section: YOUR SECTION
 * Date: 10/06/2025
 * Time: 16:31
 *
 * Project: restaurant_mgt
 * Package: com.example.SeftOrderingRestaurant.Dtos.Response
 * Class: StaffResponseDto
 *
 * Description:
 *
 * ****************************************
 */
package com.example.SeftOrderingRestaurant.Dtos.Response;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * Data Transfer Object for staff responses.
 */
@Data
public class StaffResponseDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String role;
    private boolean active;
    private String address;
    private String emergencyContact;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}