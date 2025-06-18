package com.example.SeftOrderingRestaurant.Dtos.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object for handling login requests.
 * This DTO is used to authenticate users in the system.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequestDto {
    
    @NotBlank(message = "Username or email is required")
    @Size(min = 3, max = 50, message = "Username/email must be between 3 and 50 characters")
    private String login;

    @NotBlank(message = "Password is required")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    private String password;
    
    private Boolean rememberMe = false;
}