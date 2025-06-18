package com.example.SeftOrderingRestaurant.Dtos.Response;

import lombok.*;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class PaymentItemDto {
    private Integer dishId;
    private String dishName;
    private BigDecimal price;
    private Integer quantity;
    private String notes;
}