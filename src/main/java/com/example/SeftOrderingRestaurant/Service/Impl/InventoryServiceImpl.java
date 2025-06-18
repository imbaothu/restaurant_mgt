/* *****************************************
 * CSCI 205 - Software Engineering and Design
 * Fall 2024
 * Instructor: Prof. Lily
 *
 * Name: Thu Le
 * Section: YOUR SECTION
 * Date: 05/06/2025
 * Time: 01:26
 *
 * Project: restaurant_mgt
 * Package: com.example.SeftOrderingRestaurant.Service.Impl
 * Class: InventoryServiceImpl
 *
 * Description:
 *
 * ****************************************
 */
package com.example.SeftOrderingRestaurant.Service.Impl;

import com.example.SeftOrderingRestaurant.Dtos.Request.InventoryRequestDto;
import com.example.SeftOrderingRestaurant.Dtos.Response.InventoryResponseDto;
import com.example.SeftOrderingRestaurant.Service.Interfaces.IInventoryService;
import com.example.SeftOrderingRestaurant.Entities.Inventory;
import com.example.SeftOrderingRestaurant.Repositories.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class InventoryServiceImpl implements IInventoryService {

    private final InventoryRepository inventoryRepository;

    @Override
    public InventoryResponseDto createInventoryItem(InventoryRequestDto requestDto) {
        Inventory inventory = new Inventory();
        inventory.setName(requestDto.getName());
        inventory.setCategory(requestDto.getCategory());
        inventory.setQuantity(requestDto.getQuantity());
        inventory.setUnitPrice(requestDto.getUnitPrice());
        inventory.setUnit(requestDto.getUnit());
        inventory.setDescription(requestDto.getDescription());
        inventory.setSupplierId(requestDto.getSupplierId());
        inventory.setMinimumQuantity(requestDto.getMinimumQuantity());
        inventory.setLocation(requestDto.getLocation());
        inventory = inventoryRepository.save(inventory);
        return mapToResponseDto(inventory);
    }

    @Override
    public InventoryResponseDto getInventoryItemById(Long id) {
        Inventory inventory = inventoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Inventory item not found"));
        return mapToResponseDto(inventory);
    }

    @Override
    public List<InventoryResponseDto> getAllInventoryItems() {
        return inventoryRepository.findAll().stream()
                .map(this::mapToResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public InventoryResponseDto updateInventoryItem(Long id, InventoryRequestDto requestDto) {
        Inventory inventory = inventoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Inventory item not found"));
        inventory.setName(requestDto.getName());
        inventory.setCategory(requestDto.getCategory());
        inventory.setQuantity(requestDto.getQuantity());
        inventory.setUnitPrice(requestDto.getUnitPrice());
        inventory.setUnit(requestDto.getUnit());
        inventory.setDescription(requestDto.getDescription());
        inventory.setSupplierId(requestDto.getSupplierId());
        inventory.setMinimumQuantity(requestDto.getMinimumQuantity());
        inventory.setLocation(requestDto.getLocation());
        inventory = inventoryRepository.save(inventory);
        return mapToResponseDto(inventory);
    }

    @Override
    public void deleteInventoryItem(Long id) {
        inventoryRepository.deleteById(id.intValue());
    }

    @Override
    public InventoryResponseDto updateInventoryQuantity(Long id, Integer quantity) {
        Inventory inventory = inventoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Inventory item not found"));
        inventory.setQuantity(quantity);
        inventory = inventoryRepository.save(inventory);
        return mapToResponseDto(inventory);
    }

    @Override
    public List<InventoryResponseDto> getInventoryItemsByCategory(String category) {
        return inventoryRepository.findByCategory(category).stream()
                .map(this::mapToResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<InventoryResponseDto> getLowStockItems(Integer threshold) {
        return inventoryRepository.findByQuantityLessThanEqual(threshold).stream()
                .map(this::mapToResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<InventoryResponseDto> getInventoryItemsBySupplier(Long supplierId) {
        return inventoryRepository.findBySupplierId(supplierId).stream()
                .map(this::mapToResponseDto)
                .collect(Collectors.toList());
    }

    private InventoryResponseDto mapToResponseDto(Inventory inventory) {
        InventoryResponseDto responseDto = new InventoryResponseDto();
        responseDto.setId(inventory.getId());
        responseDto.setName(inventory.getName());
        responseDto.setCategory(inventory.getCategory());
        responseDto.setQuantity(inventory.getQuantity().intValue());
        responseDto.setUnitPrice(inventory.getUnitPrice());
        responseDto.setUnit(inventory.getUnit());
        responseDto.setDescription(inventory.getDescription());
        responseDto.setSupplierId(inventory.getSupplierId());
        responseDto.setMinimumQuantity(inventory.getMinimumQuantity());
        responseDto.setLocation(inventory.getLocation());
        responseDto.setCreatedAt(inventory.getCreatedAt());
        responseDto.setUpdatedAt(inventory.getUpdatedAt());
        responseDto.setLastRestockedAt(inventory.getLastRestockedAt());
        return responseDto;
    }
}