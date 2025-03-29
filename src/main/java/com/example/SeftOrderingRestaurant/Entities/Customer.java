package com.example.SeftOrderingRestaurant.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Customers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Customer_ID")
    private Integer id;

    @OneToOne
    @JoinColumn(name = "User_ID", nullable = false, unique = true)
    private User user;

    @Column(name = "Fullname", length = 100, nullable = false)
    private String fullname;

    @Column(name = "JoinDate", updatable = false, columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime joinDate;

    @Column(name = "Points", nullable = false, columnDefinition = "INT DEFAULT 0")
    private Integer points = 0;

    @PrePersist
    protected void onCreate() {
        this.joinDate = LocalDateTime.now();
    }

    public Customer(User user, String fullname, Integer points) {
        this.user = user;
        this.fullname = fullname;
        this.points = points;
        this.joinDate = LocalDateTime.now();
    }
}