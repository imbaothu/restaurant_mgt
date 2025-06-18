package com.example.SeftOrderingRestaurant.Entities;

import com.example.SeftOrderingRestaurant.Enums.UserStatus;
import com.example.SeftOrderingRestaurant.Enums.UserType;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "User_ID")
    private Integer id;

    @Column(name = "Username", unique = true, nullable = false, length = 50)
    private String username;

    @Column(name = "Password", length = 255)
    private String password;

    @Column(name = "GoogleID", unique = true, length = 50)
    private String googleId;

    @Enumerated(EnumType.STRING)
    @Column(name = "UserType", nullable = false)
    private UserType userType;

    @Column(name = "Email", unique = true, nullable = false, length = 100)
    private String email;

    @Column(name = "Phone", length = 20)
    private String phone;

    @Enumerated(EnumType.STRING)
    @Column(name = "Status", nullable = false, columnDefinition = "ENUM('Active', 'Inactive', 'Pending') DEFAULT 'Active'")
    private UserStatus status = UserStatus.ACTIVE;

    @Column(name = "CreateAt", updatable = false, columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    @Column(name = "LastLogin")
    private LocalDateTime lastLogin;

    @Column(name = "ResetPasswordToken")
    private String resetPasswordToken;

    @Column(name = "ResetPasswordExpiry")
    private LocalDateTime resetPasswordExpiry;

    @Column(name = "UpdatedAt")
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}