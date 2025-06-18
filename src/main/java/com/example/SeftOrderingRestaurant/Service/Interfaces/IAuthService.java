package com.example.SeftOrderingRestaurant.Service.Interfaces;

import com.example.SeftOrderingRestaurant.Dtos.Request.LoginRequestDto;
import com.example.SeftOrderingRestaurant.Dtos.Request.RegisterRequestDto;
import com.example.SeftOrderingRestaurant.Dtos.Request.ForgotPasswordRequestDto;
import com.example.SeftOrderingRestaurant.Dtos.Request.ResetPasswordRequestDto;
import com.example.SeftOrderingRestaurant.Dtos.Response.AuthResponseDto;

/**
 * Service interface for handling authentication-related operations.
 */
public interface IAuthService {
    /**
     * Register a new user in the system.
     *
     * @param request The registration request containing user details
     * @return AuthResponseDto containing authentication tokens and user info
     */
    AuthResponseDto register(RegisterRequestDto request);

    /**
     * Authenticate a user and generate access token.
     *
     * @param request The login request containing credentials
     * @return AuthResponseDto containing authentication tokens and user info
     */
    AuthResponseDto login(LoginRequestDto request);

    /**
     * Refresh the authentication token.
     *
     * @param refreshToken The refresh token
     * @return AuthResponseDto containing new authentication tokens
     */
    AuthResponseDto refreshToken(String refreshToken);

    /**
     * Logout a user by invalidating their tokens.
     *
     * @param token The access token to invalidate
     */
    void logout(String token);

    /**
     * Send a forgot password email to the user.
     *
     * @param request The forgot password request containing user email
     */
    void forgotPassword(ForgotPasswordRequestDto request);

    /**
     * Reset the user's password.
     *
     * @param request The reset password request containing new password
     */
    void resetPassword(ResetPasswordRequestDto request);
} 