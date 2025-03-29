package com.example.SeftOrderingRestaurant.Repositories;

import com.example.SeftOrderingRestaurant.Entities.Shift;
import com.example.SeftOrderingRestaurant.Entities.Staff;
import com.example.SeftOrderingRestaurant.Entities.StaffShift;
import com.example.SeftOrderingRestaurant.Enums.StaffShiftStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StaffShiftRepository extends JpaRepository<StaffShift, Integer> {
    List<StaffShift> findByStaff(Staff staff);
    List<StaffShift> findByShift(Shift shift);
    List<StaffShift> findByStatus(StaffShiftStatus status);
    List<StaffShift> findByStaffAndStatus(Staff staff, StaffShiftStatus status);
}
