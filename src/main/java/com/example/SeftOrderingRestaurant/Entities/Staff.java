package com.example.SeftOrderingRestaurant.Entities;

import com.example.SeftOrderingRestaurant.Enums.StaffStatus;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "Staff")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Staff_ID")
    private Integer id;

    @OneToOne
    @JoinColumn(name = "User_ID", nullable = false, unique = true)
    private User user;

    @Column(name = "Fullname", length = 100, nullable = false)
    private String fullname;

    @Column(name = "Position", length = 50)
    private String position;

    @Column(name = "Salary", precision = 10, scale = 2)
    private BigDecimal salary;

    @Column(name = "HireDate")
    private LocalDate hireDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "Status", nullable = false, columnDefinition = "ENUM('Active', 'Inactive')")
    private StaffStatus status;
}