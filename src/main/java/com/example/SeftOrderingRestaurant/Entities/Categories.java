package com.example.SeftOrderingRestaurant.Entities;

import com.example.SeftOrderingRestaurant.Enums.CategoryStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Categories")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Categories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Category_ID")
    private Long id;

    @Column(name = "Name", length = 100, nullable = false)
    private String name;

    @Column(name = "Description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "Image", length = 255)
    private String image;

    @Column(name = "Type", length = 50)
    private String type;

    @Enumerated(EnumType.STRING)
    @Column(name = "Status", nullable = false, columnDefinition = "ENUM('Active', 'Inactive') DEFAULT 'Active'")
    private CategoryStatus status = CategoryStatus.ACTIVE;

    @Column(name = "Created_At")
    private LocalDateTime createdAt;

    @Column(name = "Updated_At")
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}