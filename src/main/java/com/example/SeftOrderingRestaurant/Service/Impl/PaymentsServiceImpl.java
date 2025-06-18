/* *****************************************
 * CSCI 205 - Software Engineering and Design
 * Fall 2024
 * Instructor: Prof. Lily
 *
 * Name: Thu Le
 * Section: YOUR SECTION
 * Date: 05/06/2025
 * Time: 01:27
 *
 * Project: restaurant_mgt
 * Package: com.example.SeftOrderingRestaurant.Service.Impl
 * Class: PaymentsServiceImpl
 *
 * Description:
 *
 * ****************************************
 */
package com.example.SeftOrderingRestaurant.Service.Impl;

import com.example.SeftOrderingRestaurant.Dtos.Request.PaymentRequestDto;
import com.example.SeftOrderingRestaurant.Dtos.Response.PaymentResponseDto;
import com.example.SeftOrderingRestaurant.Service.Interfaces.IPaymentsService;
import com.example.SeftOrderingRestaurant.Entities.Payment;
import com.example.SeftOrderingRestaurant.Repositories.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class PaymentsServiceImpl implements IPaymentsService {

    private final PaymentRepository paymentRepository;

    @Override
    public PaymentResponseDto createPayment(PaymentRequestDto requestDto) {
        Payment payment = new Payment();
        payment.setOrderId(requestDto.getOrderId());
        payment.setAmount(requestDto.getAmount());
        payment.setPaymentMethod(requestDto.getPaymentMethod());
        payment.setTransactionId(requestDto.getTransactionId());
        payment.setNotes(requestDto.getNotes());
        payment.setRefunded(requestDto.isRefunded());
        payment = paymentRepository.save(payment);
        return mapToResponseDto(payment);
    }

    @Override
    public PaymentResponseDto getPaymentById(Long id) {
        Payment payment = paymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found"));
        return mapToResponseDto(payment);
    }

    @Override
    public List<PaymentResponseDto> getAllPayments() {
        return paymentRepository.findAll().stream()
                .map(this::mapToResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public PaymentResponseDto updatePayment(Long id, PaymentRequestDto requestDto) {
        Payment payment = paymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found"));
        payment.setOrderId(requestDto.getOrderId());
        payment.setAmount(requestDto.getAmount());
        payment.setPaymentMethod(requestDto.getPaymentMethod());
        payment.setTransactionId(requestDto.getTransactionId());
        payment.setNotes(requestDto.getNotes());
        payment.setRefunded(requestDto.isRefunded());
        payment = paymentRepository.save(payment);
        return mapToResponseDto(payment);
    }

    @Override
    public void deletePayment(Long id) {
        paymentRepository.deleteById(id);
    }

    @Override
    public List<PaymentResponseDto> getPaymentsByOrder(Long orderId) {
        return paymentRepository.findByOrderId(orderId).stream()
                .map(this::mapToResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<PaymentResponseDto> getPaymentsByDateRange(String startDate, String endDate) {
        LocalDateTime start = LocalDateTime.parse(startDate);
        LocalDateTime end = LocalDateTime.parse(endDate);
        return paymentRepository.findByCreatedAtBetween(start, end).stream()
                .map(this::mapToResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<PaymentResponseDto> getPaymentsByMethod(String paymentMethod) {
        return paymentRepository.findByPaymentMethod(paymentMethod).stream()
                .map(this::mapToResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public PaymentResponseDto processRefund(Long id, String reason) {
        Payment payment = paymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found"));
        payment.setRefunded(true);
        payment.setNotes(payment.getNotes() + "\nRefund reason: " + reason);
        payment.setRefundedAt(LocalDateTime.now());
        payment = paymentRepository.save(payment);
        return mapToResponseDto(payment);
    }

    private PaymentResponseDto mapToResponseDto(Payment payment) {
        PaymentResponseDto responseDto = new PaymentResponseDto();
        responseDto.setId(payment.getId());
        responseDto.setOrderId(payment.getOrderId());
        responseDto.setAmount(payment.getAmount());
        responseDto.setPaymentMethod(payment.getPaymentMethod());
        responseDto.setTransactionId(payment.getTransactionId());
        responseDto.setNotes(payment.getNotes());
        responseDto.setRefunded(payment.isRefunded());
        responseDto.setCreatedAt(payment.getCreatedAt());
        responseDto.setUpdatedAt(payment.getUpdatedAt());
        responseDto.setRefundedAt(payment.getRefundedAt());
        return responseDto;
    }
}