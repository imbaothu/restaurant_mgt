package com.example.SeftOrderingRestaurant.Entities;

import com.example.SeftOrderingRestaurant.Enums.IngredientStatus;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "Ingredients")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ingredients {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Ingredient_ID")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "Supplier_ID", nullable = true)
    private Suppliers supplier;

    @Column(name = "Name", length = 100, nullable = false)
    private String name;

    @Column(name = "Description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "Unit", length = 50)
    private String unit;

    @Column(name = "CostPerUnit", precision = 10, scale = 2)
    private BigDecimal costPerUnit;

    @Enumerated(EnumType.STRING)
    @Column(name = "Status", nullable = false, columnDefinition = "ENUM('Available', 'Low', 'OutOfStock') DEFAULT 'Available'")
    private IngredientStatus status = IngredientStatus.AVAILABLE;

    @Column(name = "MinimumQuantity", nullable = false, columnDefinition = "INT DEFAULT 1")
    private Integer minimumQuantity = 1;
}