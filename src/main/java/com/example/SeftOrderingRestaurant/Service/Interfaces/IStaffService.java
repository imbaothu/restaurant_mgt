/* *****************************************
 * CSCI 205 - Software Engineering and Design
 * Fall 2024
 * Instructor: Prof. Lily
 *
 * Name: Thu Le
 * Section: YOUR SECTION
 * Date: 05/06/2025
 * Time: 01:39
 *
 * Project: restaurant_mgt
 * Package: com.example.SeftOrderingRestaurant.Service.Interfaces
 * Class: IStaffService
 *
 * Description:
 *
 * ****************************************
 */
package com.example.SeftOrderingRestaurant.Service.Interfaces;

import com.example.SeftOrderingRestaurant.Dtos.Request.StaffRequestDto;
import com.example.SeftOrderingRestaurant.Dtos.Response.StaffResponseDto;
import java.util.List;

/**
 * Service interface for handling staff-related operations.
 */
public interface IStaffService {
    /**
     * Create a new staff member.
     *
     * @param request The staff request containing staff details
     * @return StaffResponseDto containing the created staff information
     */
    StaffResponseDto createStaff(StaffRequestDto request);

    /**
     * Get a staff member by their ID.
     *
     * @param staffId The ID of the staff member to retrieve
     * @return StaffResponseDto containing the staff information
     */
    StaffResponseDto getStaffById(Long staffId);

    /**
     * Get all staff members.
     *
     * @return List of StaffResponseDto containing all staff members
     */
    List<StaffResponseDto> getAllStaff();

    /**
     * Update a staff member's information.
     *
     * @param staffId The ID of the staff member to update
     * @param request The staff request containing updated details
     * @return StaffResponseDto containing the updated staff information
     */
    StaffResponseDto updateStaff(Long staffId, StaffRequestDto request);

    /**
     * Delete a staff member.
     *
     * @param staffId The ID of the staff member to delete
     */
    void deleteStaff(Long staffId);

    /**
     * Get staff members by role.
     *
     * @param role The role to filter by
     * @return List of StaffResponseDto containing staff members with the specified role
     */
    List<StaffResponseDto> getStaffByRole(String role);

    /**
     * Update staff member's status.
     *
     * @param staffId The ID of the staff member to update
     * @param active The new status
     * @return StaffResponseDto containing the updated staff information
     */
    StaffResponseDto updateStaffStatus(Long staffId, boolean active);

    /**
     * Get staff members by shift.
     *
     * @param shiftId The ID of the shift
     * @return List of StaffResponseDto containing staff members assigned to the shift
     */
    List<StaffResponseDto> getStaffByShift(Long shiftId);
}