package com.example.SeftOrderingRestaurant.Entities;

import com.example.SeftOrderingRestaurant.Enums.TableStatus;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Tables")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Stable_db {

    @Id
    @Column(name = "TableNumber")
    private Integer tableNumber;

    @Column(name = "Capacity", nullable = false)
    private Integer capacity;

    @Enumerated(EnumType.STRING)
    @Column(name = "Status", nullable = false, columnDefinition = "ENUM('Available', 'Occupied') DEFAULT 'Available'")
    private TableStatus status = TableStatus.AVAILABLE;

    @Column(name = "Location", length = 50)
    private String location;

    @Column(name = "QRCode", length = 255)
    private String qrCode;
}
