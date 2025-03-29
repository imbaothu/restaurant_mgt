package com.example.SeftOrderingRestaurant.Entities;

import com.example.SeftOrderingRestaurant.Enums.OrderItemStatus;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "OrderItems")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderItems {

    @Id
    @ManyToOne
    @JoinColumn(name = "Order_ID", nullable = false)
    private Orders order;

    @Id
    @ManyToOne
    @JoinColumn(name = "Dish_ID", nullable = false)
    private Dishes dish;

    @Column(name = "Quantity", nullable = false)
    private Integer quantity;

    @Column(name = "UnitPrice", nullable = false, precision = 10, scale = 2, columnDefinition = "DECIMAL(10,2) DEFAULT 0")
    private BigDecimal unitPrice;

    @Column(name = "Notes", columnDefinition = "TEXT")
    private String notes;

    @Enumerated(EnumType.STRING)
    @Column(name = "Status", nullable = false, columnDefinition = "ENUM('Ordered', 'Processing', 'Served', 'Cancelled')")
    private OrderItemStatus status;

    @Column(name = "SubTotal", precision = 10, scale = 2)
    private BigDecimal subTotal;

    @PrePersist
    @PreUpdate
    private void calculateSubTotal() {
        this.subTotal = (this.quantity != null && this.unitPrice != null) ? this.unitPrice.multiply(BigDecimal.valueOf(this.quantity)) : BigDecimal.ZERO;
    }
}