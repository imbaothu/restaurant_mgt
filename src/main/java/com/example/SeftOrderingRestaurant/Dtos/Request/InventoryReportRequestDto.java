package com.example.SeftOrderingRestaurant.Dtos.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

/**
 * Data Transfer Object for inventory report requests.
 * This DTO is used to request inventory analysis and reports.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryReportRequestDto {
    private String reportType;  // DAILY, WEEKLY, MONTHLY, CUSTOM
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String category;  // Optional: filter by category
    private String supplier;  // Optional: filter by supplier
    private Boolean includeLowStock;  // Optional: include low stock items
    private Boolean includeExpired;  // Optional: include expired items
    private String reportFormat;  // PDF, EXCEL, CSV
    private String sortBy;  // DATE, VALUE, QUANTITY
    private String sortOrder;  // ASC, DESC
    private Integer pageSize;
    private Integer pageNumber;
    private String customFilters;  // JSON string for additional filters
} 