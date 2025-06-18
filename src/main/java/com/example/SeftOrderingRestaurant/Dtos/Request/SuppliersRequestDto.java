
package com.example.SeftOrderingRestaurant.Dtos.Request;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SuppliersRequestDto {
    private String name;
    private String address;
    private String phone;
    private String email;
    private String contactPerson;
}