package com.example.SeftOrderingRestaurant.Repositories;

import com.example.SeftOrderingRestaurant.Entities.Customer;
import com.example.SeftOrderingRestaurant.Entities.CustomerFeedback;
import com.example.SeftOrderingRestaurant.Enums.FeedbackStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CustomerFeedbackRepository extends JpaRepository<CustomerFeedback, Integer> {
    List<CustomerFeedback> findByCustomer(Customer customer);
    List<CustomerFeedback> findByRating(Integer rating);
    List<CustomerFeedback> findByStatus(FeedbackStatus status);
    List<CustomerFeedback> findByCreatedAtBetween(LocalDateTime start, LocalDateTime end);
}
