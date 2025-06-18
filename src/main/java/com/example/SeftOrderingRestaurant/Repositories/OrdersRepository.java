package com.example.SeftOrderingRestaurant.Repositories;

import com.example.SeftOrderingRestaurant.Entities.Customer;
import com.example.SeftOrderingRestaurant.Entities.Orders;
import com.example.SeftOrderingRestaurant.Enums.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer> {
    List<Orders> findByCustomer(Customer customer);
    List<Orders> findByStatus(OrderStatus status);
    List<Orders> findByOrderTimeBetween(LocalDateTime start, LocalDateTime end);
    List<Orders> findByCustomerAndStatus(Customer customer, OrderStatus status);
    List<Orders> findByOrderStatusNot(OrderStatus status);
}
