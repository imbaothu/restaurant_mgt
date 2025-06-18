/* *****************************************
 * CSCI 205 - Software Engineering and Design
 * Fall 2024
 * Instructor: Prof. Lily
 *
 * Name: Thu Le
 * Section: YOUR SECTION
 * Date: 05/06/2025
 * Time: 01:27
 *
 * Project: restaurant_mgt
 * Package: com.example.SeftOrderingRestaurant.Service.Impl
 * Class: NotificationServiceImpl
 *
 * Description:
 *
 * ****************************************
 */
package com.example.SeftOrderingRestaurant.Service.Impl;

import com.example.SeftOrderingRestaurant.Dtos.Request.NotificationRequestDto;
import com.example.SeftOrderingRestaurant.Dtos.Response.NotificationResponseDto;
import com.example.SeftOrderingRestaurant.Service.Interfaces.INotificationService;
import com.example.SeftOrderingRestaurant.Entities.Notification;
import com.example.SeftOrderingRestaurant.Entities.User;
import com.example.SeftOrderingRestaurant.Repositories.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class NotificationServiceImpl implements INotificationService {

    private final NotificationRepository notificationRepository;

    @Override
    public NotificationResponseDto createNotification(NotificationRequestDto requestDto) {
        Notification notification = new Notification();
        notification.setUserId(requestDto.getUserId());
        notification.setTitle(requestDto.getTitle());
        notification.setMessage(requestDto.getMessage());
        notification.setType(requestDto.getType());
        notification.setRead(requestDto.isRead());
        notification = notificationRepository.save(notification);
        return mapToResponseDto(notification);
    }

    @Override
    public NotificationResponseDto getNotificationById(Long id) {
        Notification notification = notificationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Notification not found"));
        return mapToResponseDto(notification);
    }

    @Override
    public List<NotificationResponseDto> getAllNotifications() {
        return notificationRepository.findAll().stream()
                .map(this::mapToResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteNotification(Long id) {
        notificationRepository.deleteById(id.intValue());
    }

    @Override
    public List<NotificationResponseDto> getNotificationsByUser(Long userId) {
        User user = new User();
        user.setId(userId.intValue());
        return notificationRepository.findByUser(user).stream()
                .map(this::mapToResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<NotificationResponseDto> getUserNotifications(Long userId) {
        User user = new User();
        user.setId(userId.intValue());
        return notificationRepository.findByUserAndIsRead(user, false).stream()
                .map(this::mapToResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<NotificationResponseDto> getNotificationsByType(Long userId, String type) {
        User user = new User();
        user.setId(userId.intValue());
        return notificationRepository.findByUserAndType(user, NotificationType.valueOf(type)).stream()
                .map(this::mapToResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public Long getUnreadCount(Long userId) {
        return notificationRepository.countByUserIdAndReadFalse(userId);
    }

    @Override
    public boolean markAllAsRead(Long userId) {
        User user = new User();
        user.setId(userId.intValue());
        List<Notification> notifications = notificationRepository.findByUserAndIsRead(user, false);
        notifications.forEach(notification -> notification.setIsRead(true));
        notificationRepository.saveAll(notifications);
        return true;
    }

    @Override
    public NotificationResponseDto markAsRead(Long notificationId) {
        Notification notification = notificationRepository.findById(notificationId.intValue())
                .orElseThrow(() -> new RuntimeException("Notification not found"));
        notification.setIsRead(true);
        return mapToResponseDto(notificationRepository.save(notification));
    }

    private NotificationResponseDto mapToResponseDto(Notification notification) {
        NotificationResponseDto responseDto = new NotificationResponseDto();
        responseDto.setId(notification.getId());
        responseDto.setUserId(notification.getUserId());
        responseDto.setTitle(notification.getTitle());
        responseDto.setMessage(notification.getMessage());
        responseDto.setType(notification.getType());
        responseDto.setRead(notification.isRead());
        responseDto.setCreatedAt(notification.getCreatedAt());
        responseDto.setUpdatedAt(notification.getUpdatedAt());
        return responseDto;
    }
}