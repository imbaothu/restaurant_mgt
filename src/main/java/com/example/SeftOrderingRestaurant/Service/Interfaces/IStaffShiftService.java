package com.example.SeftOrderingRestaurant.Service.Interfaces;

import com.example.SeftOrderingRestaurant.Dtos.Request.StaffShiftRequestDto;
import com.example.SeftOrderingRestaurant.Dtos.Response.StaffShiftResponseDto;
import java.util.List;

public interface IStaffShiftService {
    StaffShiftResponseDto createStaffShift(StaffShiftRequestDto requestDto);
    StaffShiftResponseDto getStaffShiftById(Long id);
    List<StaffShiftResponseDto> getAllStaffShifts();
    StaffShiftResponseDto updateStaffShift(Long id, StaffShiftRequestDto requestDto);
    void deleteStaffShift(Long id);
    List<StaffShiftResponseDto> getStaffShiftsByStaff(Long staffId);
    List<StaffShiftResponseDto> getStaffShiftsByShift(Long shiftId);
    List<StaffShiftResponseDto> getStaffShiftsByStatus(String status);
} 