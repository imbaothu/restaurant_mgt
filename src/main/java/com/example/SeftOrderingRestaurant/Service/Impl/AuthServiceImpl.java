package com.example.SeftOrderingRestaurant.Service.Impl;

import com.example.SeftOrderingRestaurant.Dtos.Request.*;
import com.example.SeftOrderingRestaurant.Dtos.Response.AuthResponseDto;
import com.example.SeftOrderingRestaurant.Entities.*;
import com.example.SeftOrderingRestaurant.Enums.*;
import com.example.SeftOrderingRestaurant.Repositories.*;
import com.example.SeftOrderingRestaurant.Service.Interfaces.IAuthService;
import com.example.SeftOrderingRestaurant.Service.Interfaces.EmailService;
import com.example.SeftOrderingRestaurant.Service.Interfaces.JwtTokenService;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.math.BigDecimal;
import java.security.GeneralSecurityException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements IAuthService {
    private final UserRepository userRepository;
    private final StaffRepository staffRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenService jwtTokenService;
    private final AuthenticationManager authenticationManager;
    private final EmailService emailService;

    @Value("${google.client-id}")
    private String googleClientId;

    @Override
    @Transactional
    public AuthResponseDto register(RegisterRequestDto request) {
        // Check if username or email already exists
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new RuntimeException("Username already exists");
        }
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        // Create new user
        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setPhone(request.getPhone());
        user.setUserType(UserType.STAFF);
        user.setStatus(UserStatus.ACTIVE);
        user.setCreatedAt(LocalDateTime.now());

        User savedUser = userRepository.save(user);

        // Create staff profile
        Staff staff = new Staff();
        staff.setUser(savedUser);
        staff.setFullname(request.getFullname());
        staff.setHireDate(LocalDate.now());
        staff.setPosition(request.getPosition());
        staff.setSalary(request.getSalary());
        staff.setStatus(UserStatus.ACTIVE);
        staffRepository.save(staff);

        // Generate tokens
        String accessToken = jwtTokenService.generateAccessToken(savedUser);
        String refreshToken = jwtTokenService.generateRefreshToken(savedUser);

        // Return response
        AuthResponseDto response = new AuthResponseDto();
        response.setAccessToken(accessToken);
        response.setRefreshToken(refreshToken);
        response.setUsername(savedUser.getUsername());
        response.setEmail(savedUser.getEmail());
        response.setUserType(savedUser.getUserType().name());

        return response;
    }

    @Override
    public AuthResponseDto login(LoginRequestDto request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getLogin(),
                        request.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        User user = userRepository.findByUsernameOrEmail(
                request.getLogin(),
                request.getLogin()
        ).orElseThrow(() -> new RuntimeException("User not found"));

        // Update last login
        user.setLastLogin(LocalDateTime.now());
        userRepository.save(user);

        // Generate tokens
        String accessToken = jwtTokenService.generateAccessToken(user);
        String refreshToken = jwtTokenService.generateRefreshToken(user);

        // Return response
        AuthResponseDto response = new AuthResponseDto();
        response.setAccessToken(accessToken);
        response.setRefreshToken(refreshToken);
        response.setUsername(user.getUsername());
        response.setEmail(user.getEmail());
        response.setUserType(user.getUserType().name());

        return response;
    }

    @Override
    @Transactional
    public AuthResponseDto refreshToken(String refreshToken) {
        // Validate refresh token
        String username = jwtTokenService.extractUsername(refreshToken);
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Verify refresh token
        if (!jwtTokenService.validateRefreshToken(refreshToken, user)) {
            throw new RuntimeException("Invalid refresh token");
        }

        // Generate new tokens
        String newAccessToken = jwtTokenService.generateAccessToken(user);
        String newRefreshToken = jwtTokenService.generateRefreshToken(user);

        // Return response
        AuthResponseDto response = new AuthResponseDto();
        response.setAccessToken(newAccessToken);
        response.setRefreshToken(newRefreshToken);
        response.setUsername(user.getUsername());
        response.setEmail(user.getEmail());
        response.setUserType(user.getUserType().name());

        return response;
    }

    @Override
    public void logout(String token) {
        // Clear security context
        SecurityContextHolder.clearContext();
    }

    @Override
    @Transactional
    public void forgotPassword(ForgotPasswordRequestDto request) {
        // Validate email input
        if (request.getEmail() == null || request.getEmail().trim().isEmpty()) {
            throw new IllegalArgumentException("Email must not be empty");
        }

        if (request.getUsername() == null || request.getUsername().trim().isEmpty()) {
            throw new IllegalArgumentException("Username must not be empty");
        }

        // Optional: Add email format validation
        if (!isValidEmail(request.getEmail())) {
            throw new IllegalArgumentException("Invalid email format");
        }

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found with email: " + request.getEmail()));

        // Generate reset token
        String otp = String.format("%06d", new Random().nextInt(999999));

        // Set reset token with explicit null checks
        user.setResetPasswordToken(otp);
        user.setResetPasswordExpiry(LocalDateTime.now().plusHours(10));

        try {
            userRepository.save(user);
            emailService.sendPasswordResetEmail(user.getEmail(), otp);
        } catch (Exception e) {
            // Log the actual exception
            throw new RuntimeException("Failed to process password reset", e);
        }
    }

    @Override
    @Transactional
    public void resetPassword(ResetPasswordRequestDto request) {
        User user = userRepository.findByResetPasswordToken(request.getOtp())
                .orElseThrow(() -> new RuntimeException("Invalid reset token"));

        // Check token expiry
        if (user.getResetPasswordExpiry().isBefore(LocalDateTime.now())) {
            throw new RuntimeException("OTP has expired");
        }

        // Update password
        user.setPassword(passwordEncoder.encode(request.getNewPassword()));
        user.setResetPasswordToken(null);
        user.setResetPasswordExpiry(null);
        userRepository.save(user);
    }

    // Helper method for email validation
    private boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return email != null && email.matches(emailRegex);
    }
} 