
package com.example.SeftOrderingRestaurant.Dtos.Response;

import lombok.Data;

@Data
public class CustomerFeedbackResponseDto {
    private Integer id;
    private String customerName;
    private Integer orderId;
    private Integer rating;
    private String comment;
    private String time;
    private String date;
    private Boolean checked;
}