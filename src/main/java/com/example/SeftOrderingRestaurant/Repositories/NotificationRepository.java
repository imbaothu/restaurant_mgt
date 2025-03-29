package com.example.SeftOrderingRestaurant.Repositories;

import com.example.SeftOrderingRestaurant.Entities.Notification;
import com.example.SeftOrderingRestaurant.Entities.User;
import com.example.SeftOrderingRestaurant.Enums.NotificationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Integer> {
    List<Notification> findByUser(User user);
    List<Notification> findByType(NotificationType type);
    List<Notification> findByIsRead(Boolean isRead);
    List<Notification> findByUserAndIsRead(User user, Boolean isRead);
    List<Notification> findByUserAndType(User user, NotificationType type);
    List<Notification> findByCreatedAtAfter(LocalDateTime since);
}