/* *****************************************
 * CSCI 205 - Software Engineering and Design
 * Fall 2024
 * Instructor: Prof. Lily
 *
 * Name: Thu Le
 * Section: YOUR SECTION
 * Date: 05/06/2025
 * Time: 01:38
 *
 * Project: restaurant_mgt
 * Package: com.example.SeftOrderingRestaurant.Service.Interfaces
 * Class: IShiftService
 *
 * Description:
 *
 * ****************************************
 */
package com.example.SeftOrderingRestaurant.Service.Interfaces;

import com.example.SeftOrderingRestaurant.Dtos.Request.ShiftRequestDto;
import com.example.SeftOrderingRestaurant.Dtos.Response.ShiftResponseDto;
import java.util.List;

/**
 * Service interface for handling shift-related operations.
 */
public interface IShiftService {
    /**
     * Create a new shift.
     *
     * @param request The shift request containing shift details
     * @return ShiftResponseDto containing the created shift information
     */
    ShiftResponseDto createShift(ShiftRequestDto request);

    /**
     * Get a shift by its ID.
     *
     * @param shiftId The ID of the shift to retrieve
     * @return ShiftResponseDto containing the shift information
     */
    ShiftResponseDto getShiftById(Long shiftId);

    /**
     * Get all shifts.
     *
     * @return List of ShiftResponseDto containing all shifts
     */
    List<ShiftResponseDto> getAllShifts();

    /**
     * Update a shift's information.
     *
     * @param shiftId The ID of the shift to update
     * @param request The shift request containing updated details
     * @return ShiftResponseDto containing the updated shift information
     */
    ShiftResponseDto updateShift(Long shiftId, ShiftRequestDto request);

    /**
     * Delete a shift.
     *
     * @param shiftId The ID of the shift to delete
     */
    void deleteShift(Long shiftId);

    /**
     * Get shifts by staff member.
     *
     * @param staffId The ID of the staff member
     * @return List of ShiftResponseDto containing shifts for the staff member
     */
    List<ShiftResponseDto> getShiftsByStaff(Long staffId);

    /**
     * Get shifts by date range.
     *
     * @param startDate The start date
     * @param endDate The end date
     * @return List of ShiftResponseDto containing shifts within the date range
     */
    List<ShiftResponseDto> getShiftsByDateRange(String startDate, String endDate);

    /**
     * Assign staff to a shift.
     *
     * @param shiftId The ID of the shift
     * @param staffId The ID of the staff member
     * @return ShiftResponseDto containing the updated shift information
     */
    ShiftResponseDto assignStaffToShift(Long shiftId, Long staffId);

    /**
     * Remove staff from a shift.
     *
     * @param shiftId The ID of the shift
     * @param staffId The ID of the staff member
     * @return ShiftResponseDto containing the updated shift information
     */
    ShiftResponseDto removeStaffFromShift(Long shiftId, Long staffId);
}