package com.example.SeftOrderingRestaurant.Service.Interfaces;

import com.example.SeftOrderingRestaurant.Entities.User;

/**
 * Service interface for handling JWT token operations.
 */
public interface JwtTokenService {
    /**
     * Generate an access token for a user.
     *
     * @param user The user to generate the token for
     * @return The generated access token
     */
    String generateAccessToken(User user);

    /**
     * Generate a refresh token for a user.
     *
     * @param user The user to generate the token for
     * @return The generated refresh token
     */
    String generateRefreshToken(User user);

    /**
     * Extract the username from a token.
     *
     * @param token The token to extract from
     * @return The username
     */
    String extractUsername(String token);

    /**
     * Validate an access token.
     *
     * @param token The token to validate
     * @param user The user to validate against
     * @return true if the token is valid, false otherwise
     */
    boolean validateAccessToken(String token, User user);

    /**
     * Validate a refresh token.
     *
     * @param token The token to validate
     * @param user The user to validate against
     * @return true if the token is valid, false otherwise
     */
    boolean validateRefreshToken(String token, User user);

    /**
     * Get the expiration time of a token.
     *
     * @param token The token to check
     * @return The expiration time in milliseconds
     */
    long getExpirationTime(String token);
} 