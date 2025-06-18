/* *****************************************
 * CSCI 205 - Software Engineering and Design
 * Fall 2024
 * Instructor: Prof. Lily
 *
 * Name: Thu Le
 * Section: YOUR SECTION
 * Date: 05/06/2025
 * Time: 01:39
 *
 * Project: restaurant_mgt
 * Package: com.example.SeftOrderingRestaurant.Service.Interfaces
 * Class: ISuppliersService
 *
 * Description:
 *
 * ****************************************
 */
package com.example.SeftOrderingRestaurant.Service.Interfaces;

import com.example.SeftOrderingRestaurant.Dtos.Request.SupplierRequestDto;
import com.example.SeftOrderingRestaurant.Dtos.Response.SupplierResponseDto;
import java.util.List;

/**
 * Service interface for handling supplier-related operations.
 */
public interface ISuppliersService {
    /**
     * Create a new supplier.
     *
     * @param request The supplier request containing supplier details
     * @return SupplierResponseDto containing the created supplier information
     */
    SupplierResponseDto createSupplier(SupplierRequestDto request);

    /**
     * Get a supplier by their ID.
     *
     * @param supplierId The ID of the supplier to retrieve
     * @return SupplierResponseDto containing the supplier information
     */
    SupplierResponseDto getSupplierById(Long supplierId);

    /**
     * Get all suppliers.
     *
     * @return List of SupplierResponseDto containing all suppliers
     */
    List<SupplierResponseDto> getAllSuppliers();

    /**
     * Update a supplier's information.
     *
     * @param supplierId The ID of the supplier to update
     * @param request The supplier request containing updated details
     * @return SupplierResponseDto containing the updated supplier information
     */
    SupplierResponseDto updateSupplier(Long supplierId, SupplierRequestDto request);

    /**
     * Delete a supplier.
     *
     * @param supplierId The ID of the supplier to delete
     */
    void deleteSupplier(Long supplierId);

    /**
     * Get suppliers by category.
     *
     * @param category The category to filter by
     * @return List of SupplierResponseDto containing suppliers in the specified category
     */
    List<SupplierResponseDto> getSuppliersByCategory(String category);

    /**
     * Update supplier's status.
     *
     * @param supplierId The ID of the supplier to update
     * @param active The new status
     * @return SupplierResponseDto containing the updated supplier information
     */
    SupplierResponseDto updateSupplierStatus(Long supplierId, boolean active);

    /**
     * Get suppliers by rating.
     *
     * @param minRating The minimum rating
     * @return List of SupplierResponseDto containing suppliers with rating >= minRating
     */
    List<SupplierResponseDto> getSuppliersByRating(Double minRating);
}