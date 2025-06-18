/* *****************************************
 * CSCI 205 - Software Engineering and Design
 * Fall 2024
 * Instructor: Prof. Lily
 *
 * Name: Thu Le
 * Section: YOUR SECTION
 * Date: 05/06/2025
 * Time: 01:28
 *
 * Project: restaurant_mgt
 * Package: com.example.SeftOrderingRestaurant.Service.Impl
 * Class: StaffServiceImpl
 *
 * Description:
 *
 * ****************************************
 */
package com.example.SeftOrderingRestaurant.Service.Impl;

import com.example.SeftOrderingRestaurant.Dtos.Request.StaffRequestDto;
import com.example.SeftOrderingRestaurant.Dtos.Response.StaffResponseDto;
import com.example.SeftOrderingRestaurant.Service.Interfaces.IStaffService;
import com.example.SeftOrderingRestaurant.Models.Staff;
import com.example.SeftOrderingRestaurant.Repositories.StaffRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class StaffServiceImpl implements IStaffService {

    private final StaffRepository staffRepository;

    @Override
    public StaffResponseDto createStaff(StaffRequestDto requestDto) {
        Staff staff = new Staff();
        staff.setName(requestDto.getName());
        staff.setEmail(requestDto.getEmail());
        staff.setPhone(requestDto.getPhone());
        staff.setRole(requestDto.getRole());
        staff.setStatus(requestDto.getStatus());
        staff = staffRepository.save(staff);
        return mapToResponseDto(staff);
    }

    @Override
    public StaffResponseDto getStaffById(Long id) {
        Staff staff = staffRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Staff not found"));
        return mapToResponseDto(staff);
    }

    @Override
    public List<StaffResponseDto> getAllStaff() {
        return staffRepository.findAll().stream()
                .map(this::mapToResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public StaffResponseDto updateStaff(Long id, StaffRequestDto requestDto) {
        Staff staff = staffRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Staff not found"));
        staff.setName(requestDto.getName());
        staff.setEmail(requestDto.getEmail());
        staff.setPhone(requestDto.getPhone());
        staff.setRole(requestDto.getRole());
        staff.setStatus(requestDto.getStatus());
        staff = staffRepository.save(staff);
        return mapToResponseDto(staff);
    }

    @Override
    public void deleteStaff(Long id) {
        staffRepository.deleteById(id);
    }

    @Override
    public StaffResponseDto getStaffByEmail(String email) {
        Staff staff = staffRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Staff not found"));
        return mapToResponseDto(staff);
    }

    @Override
    public List<StaffResponseDto> getStaffByRole(String role) {
        return staffRepository.findByRole(role).stream()
                .map(this::mapToResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<StaffResponseDto> getStaffByStatus(String status) {
        return staffRepository.findByStatus(status).stream()
                .map(this::mapToResponseDto)
                .collect(Collectors.toList());
    }

    private StaffResponseDto mapToResponseDto(Staff staff) {
        StaffResponseDto responseDto = new StaffResponseDto();
        responseDto.setId(staff.getId());
        responseDto.setName(staff.getName());
        responseDto.setEmail(staff.getEmail());
        responseDto.setPhone(staff.getPhone());
        responseDto.setRole(staff.getRole());
        responseDto.setStatus(staff.getStatus());
        responseDto.setCreatedAt(staff.getCreatedAt());
        responseDto.setUpdatedAt(staff.getUpdatedAt());
        return responseDto;
    }
}