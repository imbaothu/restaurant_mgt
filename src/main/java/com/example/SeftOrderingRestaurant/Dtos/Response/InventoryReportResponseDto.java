package com.example.SeftOrderingRestaurant.Dtos.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Data Transfer Object for inventory report responses.
 * This DTO is used to return inventory analysis and reports to the client.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryReportResponseDto {
    private String reportId;
    private LocalDateTime generatedAt;
    private String reportType;  // DAILY, WEEKLY, MONTHLY, CUSTOM
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    
    // Summary statistics
    private Integer totalItems;
    private Integer lowStockItems;
    private Integer outOfStockItems;
    private BigDecimal totalValue;
    private BigDecimal averageValue;
    
    // Movement statistics
    private Integer itemsAdded;
    private Integer itemsRemoved;
    private Integer itemsExpired;
    private BigDecimal valueAdded;
    private BigDecimal valueRemoved;
    
    // Performance metrics
    private Double turnoverRate;
    private Double wastageRate;
    private Double stockAccuracy;
    
    // Additional data
    private String generatedBy;
    private String notes;
    private String reportFormat;  // PDF, EXCEL, CSV
    private String downloadUrl;
} 