package com.example.SeftOrderingRestaurant.Dtos.Response;
import com.example.SeftOrderingRestaurant.Dtos.Common.OrderCommonDto;
import com.example.SeftOrderingRestaurant.Enums.OrderPaymentStatus;
import com.example.SeftOrderingRestaurant.Enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Data Transfer Object for order responses.
 * This DTO is used to return detailed order information to the client.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponseDto {
    private Long orderId;
    private Long customerId;
    private String customerName;
    private String customerEmail;
    private String customerPhone;
    private LocalDateTime orderTime;
    private LocalDateTime estimatedCompletionTime;
    private LocalDateTime actualCompletionTime;
    private BigDecimal subtotal;
    private BigDecimal tax;
    private BigDecimal discount;
    private BigDecimal totalAmount;
    private OrderStatus status;
    private OrderPaymentStatus paymentStatus;
    private String paymentMethod;
    private String paymentId;
    private Integer tableNumber;
    private String specialInstructions;
    private List<OrderCommonDto> items;
    private String orderType;  // DINE_IN, TAKEAWAY, DELIVERY
    private String deliveryAddress;
    private String deliveryInstructions;
    private String assignedStaffId;
    private String assignedStaffName;
    private Integer preparationTime;  // in minutes
    private Boolean isUrgent;
}