package com.example.SeftOrderingRestaurant.Dtos.Common;

import com.example.SeftOrderingRestaurant.Enums.OrderItemStatus;

import java.math.BigDecimal;

public class OrderCommonDto {
    private Long id;
    private Long dishId;
    private String dishName;
    private Integer quantity;
    private BigDecimal price;
    private BigDecimal subtotal;
    private OrderItemStatus status;

    public void setDishName(String unknown) {

    }
}