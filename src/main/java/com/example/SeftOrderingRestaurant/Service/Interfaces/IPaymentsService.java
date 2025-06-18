/* *****************************************
 * CSCI 205 - Software Engineering and Design
 * Fall 2024
 * Instructor: Prof. Lily
 *
 * Name: Thu Le
 * Section: YOUR SECTION
 * Date: 05/06/2025
 * Time: 01:37
 *
 * Project: restaurant_mgt
 * Package: com.example.SeftOrderingRestaurant.Service.Interfaces
 * Class: IPaymentsService
 *
 * Description:
 *
 * ****************************************
 */
package com.example.SeftOrderingRestaurant.Service.Interfaces;

import com.example.SeftOrderingRestaurant.Dtos.Request.PaymentRequestDto;
import com.example.SeftOrderingRestaurant.Dtos.Response.PaymentResponseDto;
import java.util.List;

/**
 * Service interface for handling payment-related operations.
 */
public interface IPaymentsService {
    /**
     * Create a new payment.
     *
     * @param request The payment request containing payment details
     * @return PaymentResponseDto containing the created payment information
     */
    PaymentResponseDto createPayment(PaymentRequestDto request);

    /**
     * Get a payment by its ID.
     *
     * @param paymentId The ID of the payment to retrieve
     * @return PaymentResponseDto containing the payment information
     */
    PaymentResponseDto getPaymentById(Long paymentId);

    /**
     * Get all payments.
     *
     * @return List of PaymentResponseDto containing all payments
     */
    List<PaymentResponseDto> getAllPayments();

    /**
     * Update a payment's information.
     *
     * @param paymentId The ID of the payment to update
     * @param request The payment request containing updated details
     * @return PaymentResponseDto containing the updated payment information
     */
    PaymentResponseDto updatePayment(Long paymentId, PaymentRequestDto request);

    /**
     * Delete a payment.
     *
     * @param paymentId The ID of the payment to delete
     */
    void deletePayment(Long paymentId);

    /**
     * Get payments by order.
     *
     * @param orderId The ID of the order
     * @return List of PaymentResponseDto containing payments for the order
     */
    List<PaymentResponseDto> getPaymentsByOrder(Long orderId);

    /**
     * Get payments by date range.
     *
     * @param startDate The start date
     * @param endDate The end date
     * @return List of PaymentResponseDto containing payments within the date range
     */
    List<PaymentResponseDto> getPaymentsByDateRange(String startDate, String endDate);

    /**
     * Get payments by payment method.
     *
     * @param paymentMethod The payment method to filter by
     * @return List of PaymentResponseDto containing payments with the specified method
     */
    List<PaymentResponseDto> getPaymentsByMethod(String paymentMethod);

    /**
     * Process a refund.
     *
     * @param paymentId The ID of the payment to refund
     * @param amount The amount to refund
     * @return PaymentResponseDto containing the refund information
     */
    PaymentResponseDto processRefund(Long paymentId, Double amount);
}