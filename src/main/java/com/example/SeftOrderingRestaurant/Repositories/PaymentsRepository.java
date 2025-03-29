package com.example.SeftOrderingRestaurant.Repositories;

import com.example.SeftOrderingRestaurant.Entities.Orders;
import com.example.SeftOrderingRestaurant.Entities.Payments;
import com.example.SeftOrderingRestaurant.Enums.PaymentMethod;
import com.example.SeftOrderingRestaurant.Enums.PaymentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface PaymentsRepository extends JpaRepository<Payments, Integer> {
    Optional<Payments> findByOrder(Orders order);
    List<Payments> findByStatus(PaymentStatus status);
    List<Payments> findByPaymentMethod(PaymentMethod paymentMethod);
    List<Payments> findByPaymentDateBetween(LocalDateTime start, LocalDateTime end);
}