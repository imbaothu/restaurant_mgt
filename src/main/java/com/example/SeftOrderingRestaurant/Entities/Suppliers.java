package com.example.SeftOrderingRestaurant.Entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Suppliers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Suppliers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Supplier_ID")
    private Integer id;

    @Column(name = "Name", length = 100, nullable = false)
    private String name;

    @Column(name = "ContactPerson", length = 100)
    private String contactPerson;

    @Column(name = "Phone", length = 20)
    private String phone;

    @Column(name = "Email", length = 100, unique = true)
    private String email;

    @Column(name = "Address", columnDefinition = "TEXT")
    private String address;
}