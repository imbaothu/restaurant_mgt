/* *****************************************
 * CSCI 205 - Software Engineering and Design
 * Fall 2024
 * Instructor: Prof. Lily
 *
 * Name: Thu Le
 * Section: YOUR SECTION
 * Date: 05/06/2025
 * Time: 01:38
 *
 * Project: restaurant_mgt
 * Package: com.example.SeftOrderingRestaurant.Service.Interfaces
 * Class: IStable_dbService
 *
 * Description:
 *
 * ****************************************
 */
package com.example.SeftOrderingRestaurant.Service.Interfaces;

import com.example.SeftOrderingRestaurant.Dtos.Request.TableRequestDto;
import com.example.SeftOrderingRestaurant.Dtos.Response.TableResponseDto;
import java.util.List;

public interface IStable_dbService {
    TableResponseDto createTable(TableRequestDto requestDto);
    TableResponseDto getTableById(Long id);
    List<TableResponseDto> getAllTables();
    TableResponseDto updateTable(Long id, TableRequestDto requestDto);
    void deleteTable(Long id);
    List<TableResponseDto> getTablesByCapacity(Integer capacity);
    List<TableResponseDto> getAvailableTables();
    List<TableResponseDto> getTablesByStatus(String status);
}