/* *****************************************
 * CSCI 205 - Software Engineering and Design
 * Fall 2024
 * Instructor: Prof. Lily
 *
 * Name: Thu Le
 * Section: YOUR SECTION
 * Date: 05/06/2025
 * Time: 01:34
 *
 * Project: restaurant_mgt
 * Package: com.example.SeftOrderingRestaurant.Service.Interfaces
 * Class: ICustomerFeedbackService
 *
 * Description:
 *
 * ****************************************
 */
package com.example.SeftOrderingRestaurant.Service.Interfaces;

import com.example.SeftOrderingRestaurant.Dtos.Request.CustomerFeedbackRequestDto;
import com.example.SeftOrderingRestaurant.Dtos.Response.CustomerFeedbackResponseDto;
import java.util.List;

public interface ICustomerFeedbackService {
    CustomerFeedbackResponseDto createFeedback(CustomerFeedbackRequestDto requestDto);
    CustomerFeedbackResponseDto getFeedbackById(Long id);
    List<CustomerFeedbackResponseDto> getAllFeedback();
    CustomerFeedbackResponseDto updateFeedback(Long id, CustomerFeedbackRequestDto requestDto);
    void deleteFeedback(Long id);
    List<CustomerFeedbackResponseDto> getFeedbackByOrder(Long orderId);
    List<CustomerFeedbackResponseDto> getFeedbackByRating(Integer rating);
    List<CustomerFeedbackResponseDto> getFeedbackByDateRange(String startDate, String endDate);
}