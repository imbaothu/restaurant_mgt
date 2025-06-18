
package com.example.SeftOrderingRestaurant.Dtos.Response;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DishDto {
    private Integer id;
    private String name;
    private Integer quantity;
    private Integer price;
    private String status;
    private String image;
    private Integer orderId;
}