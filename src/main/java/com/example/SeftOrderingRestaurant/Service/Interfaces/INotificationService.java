/* *****************************************
 * CSCI 205 - Software Engineering and Design
 * Fall 2024
 * Instructor: Prof. Lily
 *
 * Name: Thu Le
 * Section: YOUR SECTION
 * Date: 05/06/2025
 * Time: 01:36
 *
 * Project: restaurant_mgt
 * Package: com.example.SeftOrderingRestaurant.Service.Interfaces
 * Class: INotificationService
 *
 * Description:
 *
 * ****************************************
 */
package com.example.SeftOrderingRestaurant.Service.Interfaces;

import com.example.SeftOrderingRestaurant.Dtos.Request.NotificationRequestDto;
import com.example.SeftOrderingRestaurant.Dtos.Response.NotificationResponseDto;
import java.util.List;

/**
 * Service interface for handling notification-related operations.
 */
public interface INotificationService {
    /**
     * Create a new notification.
     *
     * @param request The notification request containing notification details
     * @return NotificationResponseDto containing the created notification information
     */
    NotificationResponseDto createNotification(NotificationRequestDto request);

    /**
     * Get a notification by its ID.
     *
     * @param notificationId The ID of the notification to retrieve
     * @return NotificationResponseDto containing the notification information
     */
    NotificationResponseDto getNotificationById(Long notificationId);

    /**
     * Get all notifications for a user.
     *
     * @param userId The ID of the user
     * @return List of NotificationResponseDto containing the user's notifications
     */
    List<NotificationResponseDto> getUserNotifications(Long userId);

    /**
     * Mark a notification as read.
     *
     * @param notificationId The ID of the notification to mark as read
     * @return NotificationResponseDto containing the updated notification information
     */
    NotificationResponseDto markAsRead(Long notificationId);

    /**
     * Mark all notifications as read for a user.
     *
     * @param userId The ID of the user
     * @return true if all notifications were marked as read successfully
     */
    boolean markAllAsRead(Long userId);

    /**
     * Delete a notification.
     *
     * @param notificationId The ID of the notification to delete
     */
    void deleteNotification(Long notificationId);

    /**
     * Get unread notifications count for a user.
     *
     * @param userId The ID of the user
     * @return The number of unread notifications
     */
    int getUnreadCount(Long userId);

    /**
     * Get notifications by type.
     *
     * @param userId The ID of the user
     * @param type The type of notifications to retrieve
     * @return List of NotificationResponseDto containing notifications of the specified type
     */
    List<NotificationResponseDto> getNotificationsByType(Long userId, String type);
}