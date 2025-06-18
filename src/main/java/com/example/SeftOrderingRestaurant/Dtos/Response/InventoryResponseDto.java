/* *****************************************
 * CSCI 205 - Software Engineering and Design
 * Fall 2024
 * Instructor: Prof. Lily
 *
 * Name: Thu Le
 * Section: YOUR SECTION
 * Date: 10/06/2025
 * Time: 16:09
 *
 * Project: restaurant_mgt
 * Package: com.example.SeftOrderingRestaurant.Dtos.Response
 * Class: InventoryResponseDTO
 *
 * Description:
 *
 * ****************************************
 */
package com.example.SeftOrderingRestaurant.Dtos.Response;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * Data Transfer Object for inventory responses.
 */
@Data
public class InventoryResponseDto {
    private Long id;
    private String name;
    private String category;
    private Integer quantity;
    private Double unitPrice;
    private String unit;
    private String description;
    private Long supplierId;
    private String supplierName;
    private Integer minimumQuantity;
    private String location;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime lastRestockedAt;
}