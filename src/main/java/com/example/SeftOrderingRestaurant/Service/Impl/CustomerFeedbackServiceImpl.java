
package com.example.SeftOrderingRestaurant.Service.Impl;

import com.example.SeftOrderingRestaurant.Dtos.Request.CustomerFeedbackRequestDto;
import com.example.SeftOrderingRestaurant.Dtos.Response.CustomerFeedbackResponseDto;
import com.example.SeftOrderingRestaurant.Service.Interfaces.ICustomerFeedbackService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CustomerFeedbackServiceImpl implements ICustomerFeedbackService {
    @Override
    public CustomerFeedbackResponseDto createFeedback(CustomerFeedbackRequestDto requestDto) {
        return null;
    }

    @Override
    public CustomerFeedbackResponseDto getFeedbackById(Long id) {
        return null;
    }

    @Override
    public List<CustomerFeedbackResponseDto> getAllFeedback() {
        return null;
    }

    @Override
    public CustomerFeedbackResponseDto updateFeedback(Long id, CustomerFeedbackRequestDto requestDto) {
        return null;
    }

    @Override
    public void deleteFeedback(Long id) {
    }

    @Override
    public List<CustomerFeedbackResponseDto> getFeedbackByOrder(Long orderId) {
        return null;
    }

    @Override
    public List<CustomerFeedbackResponseDto> getFeedbackByRating(Integer rating) {
        return null;
    }

    @Override
    public List<CustomerFeedbackResponseDto> getFeedbackByDateRange(String startDate, String endDate) {
        return null;
    }
}