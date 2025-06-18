package com.example.SeftOrderingRestaurant.Service.Interfaces;

import com.example.SeftOrderingRestaurant.Dtos.Request.CustomerRequestDto;
import com.example.SeftOrderingRestaurant.Dtos.Response.CustomerResponseDto;
import java.util.List;

public interface ICustomerService {
    CustomerResponseDto createCustomer(CustomerRequestDto requestDto);
    CustomerResponseDto getCustomerById(Long id);
    List<CustomerResponseDto> getAllCustomers();
    CustomerResponseDto updateCustomer(Long id, CustomerRequestDto requestDto);
    void deleteCustomer(Long id);
    CustomerResponseDto getCustomerByEmail(String email);
    List<CustomerResponseDto> getCustomersByPhone(String phone);
} 