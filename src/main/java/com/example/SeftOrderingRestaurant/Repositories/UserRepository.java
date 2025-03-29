package com.example.SeftOrderingRestaurant.Repositories;


import com.example.SeftOrderingRestaurant.Entities.User;
import com.example.SeftOrderingRestaurant.Enums.UserStatus;
import com.example.SeftOrderingRestaurant.Enums.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
    List<User> findByStatus(UserStatus status);
    List<User> findByUserType(UserType userType);
    Optional<User> findByGoogleId(String googleId);
}
