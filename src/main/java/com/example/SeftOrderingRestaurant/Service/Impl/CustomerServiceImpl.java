/* *****************************************
 * CSCI 205 - Software Engineering and Design
 * Fall 2024
 * Instructor: Prof. Lily
 *
 * Name: Thu Le
 * Section: YOUR SECTION
 * Date: 05/06/2025
 * Time: 01:24
 *
 * Project: restaurant_mgt
 * Package: com.example.SeftOrderingRestaurant.Service.Impl
 * Class: CustomerServiceImpl
 *
 * Description:
 *
 * ****************************************
 */
package com.example.SeftOrderingRestaurant.Service.Impl;

import com.example.SeftOrderingRestaurant.Dtos.Request.CustomerRequestDto;
import com.example.SeftOrderingRestaurant.Dtos.Response.CustomerResponseDto;
import com.example.SeftOrderingRestaurant.Service.Interfaces.ICustomerService;
import com.example.SeftOrderingRestaurant.Entities.Customer;
import com.example.SeftOrderingRestaurant.Repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class CustomerServiceImpl implements ICustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public CustomerResponseDto createCustomer(CustomerRequestDto requestDto) {
        Customer customer = new Customer();
        customer.setName(requestDto.getName());
        customer.setEmail(requestDto.getEmail());
        customer.setPhone(requestDto.getPhone());
        customer.setAddress(requestDto.getAddress());
        customer = customerRepository.save(customer);
        return mapToResponseDto(customer);
    }

    @Override
    public CustomerResponseDto getCustomerById(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        return mapToResponseDto(customer);
    }

    @Override
    public List<CustomerResponseDto> getAllCustomers() {
        return customerRepository.findAll().stream()
                .map(this::mapToResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerResponseDto updateCustomer(Long id, CustomerRequestDto requestDto) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        customer.setName(requestDto.getName());
        customer.setEmail(requestDto.getEmail());
        customer.setPhone(requestDto.getPhone());
        customer.setAddress(requestDto.getAddress());
        customer = customerRepository.save(customer);
        return mapToResponseDto(customer);
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public CustomerResponseDto getCustomerByEmail(String email) {
        Customer customer = customerRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        return mapToResponseDto(customer);
    }

    @Override
    public List<CustomerResponseDto> getCustomersByPhone(String phone) {
        return customerRepository.findByPhone(phone).stream()
                .map(this::mapToResponseDto)
                .collect(Collectors.toList());
    }

    private CustomerResponseDto mapToResponseDto(Customer customer) {
        CustomerResponseDto responseDto = new CustomerResponseDto();
        responseDto.setId(customer.getId());
        responseDto.setName(customer.getName());
        responseDto.setEmail(customer.getEmail());
        responseDto.setPhone(customer.getPhone());
        responseDto.setAddress(customer.getAddress());
        responseDto.setCreatedAt(customer.getCreatedAt());
        responseDto.setUpdatedAt(customer.getUpdatedAt());
        return responseDto;
    }
}