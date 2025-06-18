package com.example.SeftOrderingRestaurant.Dtos.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

/**
 * Data Transfer Object for authentication responses.
 * This DTO is used to return authentication and user information after successful login.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponseDto {
    private String accessToken;
    private String refreshToken;
    private String tokenType = "Bearer";
    private Long expiresIn;
    private String username;
    private String email;
    private String userType;
    private String fullName;
    private LocalDateTime lastLogin;
    private Boolean isFirstLogin;
    private String[] permissions;
    private String profileImageUrl;
}