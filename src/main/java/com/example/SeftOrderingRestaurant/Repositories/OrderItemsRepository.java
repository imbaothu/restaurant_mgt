package com.example.SeftOrderingRestaurant.Repositories;

import com.example.SeftOrderingRestaurant.Entities.Dishes;
import com.example.SeftOrderingRestaurant.Entities.OrderItems;
import com.example.SeftOrderingRestaurant.Entities.Orders;
import com.example.SeftOrderingRestaurant.Enums.OrderItemStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemsRepository extends JpaRepository<OrderItems, Integer> {
    List<OrderItems> findByOrder(Orders order);
    List<OrderItems> findByDish(Dishes dish);
    List<OrderItems> findByStatus(OrderItemStatus status);
    List<OrderItems> findByOrderAndDish(Orders order, Dishes dish);

    List<OrderItems> findByOrderId(Long orderId);
}