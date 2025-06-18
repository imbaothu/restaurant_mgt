
package com.example.SeftOrderingRestaurant.Service.Impl;

import com.example.SeftOrderingRestaurant.Dtos.Request.ShiftRequestDto;
import com.example.SeftOrderingRestaurant.Dtos.Response.ShiftResponseDto;
import com.example.SeftOrderingRestaurant.Service.Interfaces.IShiftService;
import com.example.SeftOrderingRestaurant.Models.Shift;
import com.example.SeftOrderingRestaurant.Repositories.ShiftRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class ShiftServiceImpl implements IShiftService {

    private final ShiftRepository shiftRepository;

    @Override
    public ShiftResponseDto createShift(ShiftRequestDto requestDto) {
        Shift shift = new Shift();
        shift.setStaffId(requestDto.getStaffId());
        shift.setStartTime(requestDto.getStartTime());
        shift.setEndTime(requestDto.getEndTime());
        shift.setType(requestDto.getType());
        shift.setStatus(requestDto.getStatus());
        shift = shiftRepository.save(shift);
        return mapToResponseDto(shift);
    }

    @Override
    public ShiftResponseDto getShiftById(Long id) {
        Shift shift = shiftRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Shift not found"));
        return mapToResponseDto(shift);
    }

    @Override
    public List<ShiftResponseDto> getAllShifts() {
        return shiftRepository.findAll().stream()
                .map(this::mapToResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public ShiftResponseDto updateShift(Long id, ShiftRequestDto requestDto) {
        Shift shift = shiftRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Shift not found"));
        shift.setStaffId(requestDto.getStaffId());
        shift.setStartTime(requestDto.getStartTime());
        shift.setEndTime(requestDto.getEndTime());
        shift.setType(requestDto.getType());
        shift.setStatus(requestDto.getStatus());
        shift = shiftRepository.save(shift);
        return mapToResponseDto(shift);
    }

    @Override
    public void deleteShift(Long id) {
        shiftRepository.deleteById(id);
    }

    @Override
    public List<ShiftResponseDto> getShiftsByStaff(Long staffId) {
        return shiftRepository.findByStaffId(staffId).stream()
                .map(this::mapToResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ShiftResponseDto> getShiftsByDateRange(String startDate, String endDate) {
        LocalDateTime start = LocalDateTime.parse(startDate);
        LocalDateTime end = LocalDateTime.parse(endDate);
        return shiftRepository.findByStartTimeBetween(start, end).stream()
                .map(this::mapToResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ShiftResponseDto> getShiftsByType(String type) {
        return shiftRepository.findByType(type).stream()
                .map(this::mapToResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ShiftResponseDto> getShiftsByStatus(String status) {
        return shiftRepository.findByStatus(status).stream()
                .map(this::mapToResponseDto)
                .collect(Collectors.toList());
    }

    private ShiftResponseDto mapToResponseDto(Shift shift) {
        ShiftResponseDto responseDto = new ShiftResponseDto();
        responseDto.setId(shift.getId());
        responseDto.setStaffId(shift.getStaffId());
        responseDto.setStartTime(shift.getStartTime());
        responseDto.setEndTime(shift.getEndTime());
        responseDto.setType(shift.getType());
        responseDto.setStatus(shift.getStatus());
        responseDto.setCreatedAt(shift.getCreatedAt());
        responseDto.setUpdatedAt(shift.getUpdatedAt());
        return responseDto;
    }
}