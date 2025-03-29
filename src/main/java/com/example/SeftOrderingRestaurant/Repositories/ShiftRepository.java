package com.example.SeftOrderingRestaurant.Repositories;

import com.example.SeftOrderingRestaurant.Entities.Shift;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface ShiftRepository extends JpaRepository<Shift, Integer> {
    List<Shift> findByShiftDate(LocalDate shiftDate);
    List<Shift> findByShiftDateBetween(LocalDate startDate, LocalDate endDate);
    List<Shift> findByStartTimeBefore(LocalTime time);
    List<Shift> findByEndTimeAfter(LocalTime time);
}