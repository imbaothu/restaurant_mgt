package com.example.SeftOrderingRestaurant.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "Inventory", uniqueConstraints = @UniqueConstraint(columnNames = {"IngredientID", "Supplier_ID"}))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "InventoryID")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "IngredientID", nullable = false)
    private Ingredients ingredient;

    @Column(name = "Quantity", precision = 10, scale = 2)
    private BigDecimal quantity;

    @Column(name = "Unit", length = 50)
    private String unit;

    @ManyToOne
    @JoinColumn(name = "Supplier_ID", nullable = true)
    private Suppliers supplier;

    @Column(name = "LastUpdated", nullable = false, columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private LocalDateTime lastUpdated;

    @PrePersist
    @PreUpdate
    protected void onUpdate() {
        this.lastUpdated = LocalDateTime.now();
    }
}
