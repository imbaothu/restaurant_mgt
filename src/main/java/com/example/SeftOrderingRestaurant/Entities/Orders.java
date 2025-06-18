package com.example.SeftOrderingRestaurant.Entities;

import com.example.SeftOrderingRestaurant.Enums.OrderStatus;
import com.example.SeftOrderingRestaurant.Enums.OrderPaymentStatus;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "Orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Order_ID")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "Staff_ID", nullable = true)
    private Staff staff;

    @ManyToOne
    @JoinColumn(name = "TableNumber", nullable = true)
    private Stable_db table;

    @ManyToOne
    @JoinColumn(name = "Customer_ID", nullable = true)
    private Customer customer;

    @Column(name = "OrderDate", nullable = false, columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "Status", nullable = false, columnDefinition = "ENUM('Pending', 'Processing', 'Completed', 'Cancelled') DEFAULT 'Pending'")
    private OrderStatus status = OrderStatus.PENDING;

    @Column(name = "TotalAmount", nullable = false, precision = 10, scale = 2, columnDefinition = "DECIMAL(10,2) DEFAULT 0")
    private BigDecimal totalAmount = BigDecimal.ZERO;

    @Column(name = "Discount", nullable = false, precision = 10, scale = 2, columnDefinition = "DECIMAL(10,2) DEFAULT 0")
    private BigDecimal discount = BigDecimal.ZERO;

    @Column(name = "Notes", columnDefinition = "TEXT")
    private String notes;

    @Enumerated(EnumType.STRING)
    @Column(name = "PaymentStatus", nullable = false)
    private OrderPaymentStatus paymentStatus;

    @PrePersist
    protected void onCreate() {
        this.orderDate = LocalDateTime.now();
    }

    public void setOrderPaymentStatus(OrderPaymentStatus orderPaymentStatus) {
    }

    public Long getCustomerId() {
    }

    public OrderStatus getOrderStatus() {
    }

    public OrderPaymentStatus getOrderPaymentStatus() {
    }

    public void setCustomerId(Long customerId) {
    }

    public void setOrderTime(LocalDateTime now) {
    }

    public void setOrderStatus(OrderStatus orderStatus) {
    }

    public LocalDateTime getOrderTime() {
        return null;
    }
}