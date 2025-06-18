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
 * Class: IUserService
 *
 * Description:
 *
 * ****************************************
 */
package com.example.SeftOrderingRestaurant.Service.Interfaces;

import com.example.SeftOrderingRestaurant.Dtos.Request.UserRequestDto;
import com.example.SeftOrderingRestaurant.Dtos.Response.UserResponseDto;
import java.util.List;

/**
 * Service interface for handling user-related operations.
 */
public interface IUserService {
    /**
     * Create a new user.
     *
     * @param request The user request containing user details
     * @return UserResponseDto containing the created user information
     */
    UserResponseDto createUser(UserRequestDto request);

    /**
     * Get a user by their ID.
     *
     * @param userId The ID of the user to retrieve
     * @return UserResponseDto containing the user information
     */
    UserResponseDto getUserById(Long userId);

    /**
     * Get all users.
     *
     * @return List of UserResponseDto containing all users
     */
    List<UserResponseDto> getAllUsers();

    /**
     * Update a user's information.
     *
     * @param userId The ID of the user to update
     * @param request The user request containing updated details
     * @return UserResponseDto containing the updated user information
     */
    UserResponseDto updateUser(Long userId, UserRequestDto request);

    /**
     * Delete a user.
     *
     * @param userId The ID of the user to delete
     */
    void deleteUser(Long userId);

    /**
     * Get users by role.
     *
     * @param role The role to filter by
     * @return List of UserResponseDto containing users with the specified role
     */
    List<UserResponseDto> getUsersByRole(String role);

    /**
     * Update user's status.
     *
     * @param userId The ID of the user to update
     * @param active The new status
     * @return UserResponseDto containing the updated user information
     */
    UserResponseDto updateUserStatus(Long userId, boolean active);

    /**
     * Change user's password.
     *
     * @param userId The ID of the user
     * @param currentPassword The current password
     * @param newPassword The new password
     * @return true if password was changed successfully
     */
    boolean changePassword(Long userId, String currentPassword, String newPassword);

    /**
     * Reset user's password.
     *
     * @param email The email of the user
     * @return true if password reset was initiated successfully
     */
    boolean resetPassword(String email);
}