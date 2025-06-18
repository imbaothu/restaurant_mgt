/* *****************************************
 * CSCI 205 - Software Engineering and Design
 * Fall 2024
 * Instructor: Prof. Lily
 *
 * Name: Thu Le
 * Section: YOUR SECTION
 * Date: 05/06/2025
 * Time: 01:29
 *
 * Project: restaurant_mgt
 * Package: com.example.SeftOrderingRestaurant.Service.Impl
 * Class: StaffShiftServiceImpl
 *
 * Description:
 *
 * ****************************************
 */
package com.example.SeftOrderingRestaurant.Service.Impl;

import com.example.SeftOrderingRestaurant.Dtos.Request.StaffShiftRequestDto;
import com.example.SeftOrderingRestaurant.Dtos.Response.StaffShiftResponseDto;
import com.example.SeftOrderingRestaurant.Service.Interfaces.IStaffShiftService;
import com.example.SeftOrderingRestaurant.Models.StaffShift;
import com.example.SeftOrderingRestaurant.Repositories.StaffShiftRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class StaffShiftServiceImpl implements IStaffShiftService {

    private final StaffShiftRepository staffShiftRepository;

    @Override
    public StaffShiftResponseDto createStaffShift(StaffShiftRequestDto requestDto) {
        StaffShift staffShift = new StaffShift();
        staffShift.setStaffId(requestDto.getStaffId());
        staffShift.setShiftId(requestDto.getShiftId());
        staffShift.setStatus(requestDto.getStatus());
        staffShift = staffShiftRepository.save(staffShift);
        return mapToResponseDto(staffShift);
    }

    @Override
    public StaffShiftResponseDto getStaffShiftById(Long id) {
        StaffShift staffShift = staffShiftRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Staff shift not found"));
        return mapToResponseDto(staffShift);
    }

    @Override
    public List<StaffShiftResponseDto> getAllStaffShifts() {
        return staffShiftRepository.findAll().stream()
                .map(this::mapToResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public StaffShiftResponseDto updateStaffShift(Long id, StaffShiftRequestDto requestDto) {
        StaffShift staffShift = staffShiftRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Staff shift not found"));
        staffShift.setStaffId(requestDto.getStaffId());
        staffShift.setShiftId(requestDto.getShiftId());
        staffShift.setStatus(requestDto.getStatus());
        staffShift = staffShiftRepository.save(staffShift);
        return mapToResponseDto(staffShift);
    }

    @Override
    public void deleteStaffShift(Long id) {
        staffShiftRepository.deleteById(id);
    }

    @Override
    public List<StaffShiftResponseDto> getStaffShiftsByStaff(Long staffId) {
        return staffShiftRepository.findByStaffId(staffId).stream()
                .map(this::mapToResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<StaffShiftResponseDto> getStaffShiftsByShift(Long shiftId) {
        return staffShiftRepository.findByShiftId(shiftId).stream()
                .map(this::mapToResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<StaffShiftResponseDto> getStaffShiftsByStatus(String status) {
        return staffShiftRepository.findByStatus(status).stream()
                .map(this::mapToResponseDto)
                .collect(Collectors.toList());
    }

    private StaffShiftResponseDto mapToResponseDto(StaffShift staffShift) {
        StaffShiftResponseDto responseDto = new StaffShiftResponseDto();
        responseDto.setId(staffShift.getId());
        responseDto.setStaffId(staffShift.getStaffId());
        responseDto.setShiftId(staffShift.getShiftId());
        responseDto.setStatus(staffShift.getStatus());
        responseDto.setCreatedAt(staffShift.getCreatedAt());
        responseDto.setUpdatedAt(staffShift.getUpdatedAt());
        return responseDto;
    }
}