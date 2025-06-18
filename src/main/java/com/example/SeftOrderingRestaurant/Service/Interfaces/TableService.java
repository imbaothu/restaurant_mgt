package com.example.SeftOrderingRestaurant.Service.Interfaces;

import com.example.SeftOrderingRestaurant.Dtos.Request.TableRequestDto;
import com.example.SeftOrderingRestaurant.Dtos.Response.TableResponseDto;
import java.util.List;

/**
 * Service interface for handling table-related operations.
 */
public interface TableService {
    /**
     * Create a new table.
     *
     * @param request The table request containing table details
     * @return TableResponseDto containing the created table information
     */
    TableResponseDto createTable(TableRequestDto request);

    /**
     * Get a table by its number.
     *
     * @param tableNumber The number of the table to retrieve
     * @return TableResponseDto containing the table information
     */
    TableResponseDto getTableByNumber(Integer tableNumber);

    /**
     * Get all tables.
     *
     * @return List of TableResponseDto containing all tables
     */
    List<TableResponseDto> getAllTables();

    /**
     * Update a table's information.
     *
     * @param tableNumber The number of the table to update
     * @param request The table request containing updated details
     * @return TableResponseDto containing the updated table information
     */
    TableResponseDto updateTable(Integer tableNumber, TableRequestDto request);

    /**
     * Delete a table.
     *
     * @param tableNumber The number of the table to delete
     */
    void deleteTable(Integer tableNumber);

    /**
     * Get all available tables.
     *
     * @return List of TableResponseDto containing available tables
     */
    List<TableResponseDto> getAvailableTables();

    /**
     * Get tables by capacity range.
     *
     * @param minCapacity The minimum capacity
     * @param maxCapacity The maximum capacity
     * @return List of TableResponseDto containing tables within the capacity range
     */
    List<TableResponseDto> getTablesByCapacityRange(Integer minCapacity, Integer maxCapacity);

    /**
     * Update table status.
     *
     * @param tableNumber The number of the table to update
     * @param status The new status to set
     * @return TableResponseDto containing the updated table information
     */
    TableResponseDto updateTableStatus(Integer tableNumber, String status);
} 