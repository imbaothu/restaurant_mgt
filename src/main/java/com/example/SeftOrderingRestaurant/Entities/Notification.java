package com.example.SeftOrderingRestaurant.Entities;

import com.example.SeftOrderingRestaurant.Enums.NotificationType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Notifications")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Notification_ID")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "User_ID", nullable = false)
    private User user;

    @Column(name = "Title", length = 255, nullable = false)
    private String title;

    @Column(name = "Content", columnDefinition = "TEXT", nullable = false)
    private String content;

    @Column(name = "ExpiryDate")
    private LocalDateTime expiryDate;

    @Column(name = "CreateAt", updatable = false, columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    @Column(name = "IsRead", nullable = false, columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean isRead = false;

    @Enumerated(EnumType.STRING)
    @Column(name = "Type", nullable = false)
    private NotificationType type;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
}