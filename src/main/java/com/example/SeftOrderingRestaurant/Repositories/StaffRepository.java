package com.example.SeftOrderingRestaurant.Repositories;

import com.example.SeftOrderingRestaurant.Entities.Staff;
import com.example.SeftOrderingRestaurant.Entities.User;
import com.example.SeftOrderingRestaurant.Enums.StaffStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Integer> {
    Optional<Staff> findByUser(User user);
    List<Staff> findByStatus(StaffStatus status);
    Optional<Staff> findByEmployeeId(String employeeId);
}
