package com.example.SeftOrderingRestaurant.Entities;

import com.example.SeftOrderingRestaurant.Enums.PaymentMethod;
import com.example.SeftOrderingRestaurant.Enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "Payments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Payments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Payment_ID")
    private Integer id;

    @OneToOne
    @JoinColumn(name = "Order_ID", nullable = false)
    private Orders order;

    @ManyToOne
    @JoinColumn(name = "Customer_ID", nullable = true)
    private Customer customer;

    @Column(name = "Amount", nullable = false, precision = 10, scale = 2)
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    @Column(name = "PaymentMethod", nullable = false)
    private PaymentMethod paymentMethod;

    @Column(name = "PaymentDate", nullable = false, columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime paymentDate;

    @Column(name = "TransactionID", length = 255, unique = true)
    private String transactionId;

    @Enumerated(EnumType.STRING)
    @Column(name = "Status", nullable = false)
    private PaymentStatus status;

    @PrePersist
    protected void onCreate() {
        this.paymentDate = LocalDateTime.now();
    }

    public void setOrderId(Long orderId) {

    }
}