package com.example.SeftOrderingRestaurant.Entities;

import com.example.SeftOrderingRestaurant.Enums.StaffShiftStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "StaffShifts", uniqueConstraints = @UniqueConstraint(columnNames = {"Shift_ID", "Staff_ID", "Date"}))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StaffShift {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "StaffShift_ID")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "Shift_ID", nullable = false)
    private Shift shift;

    @ManyToOne
    @JoinColumn(name = "Staff_ID", nullable = false)
    private Staff staff;

    @Column(name = "Date", nullable = false)
    private LocalDate date;

    @Enumerated(EnumType.STRING)
    @Column(name = "Status", nullable = false, columnDefinition = "ENUM('Assigned', 'Completed', 'Absent')")
    private StaffShiftStatus status;
}