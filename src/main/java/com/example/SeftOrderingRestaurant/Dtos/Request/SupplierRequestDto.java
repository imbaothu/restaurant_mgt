package com.example.SeftOrderingRestaurant.Dtos.Request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * Data Transfer Object for supplier creation and update requests.
 */
@Data
public class SupplierRequestDto {
    @NotBlank(message = "Company name is required")
    @Size(min = 2, max = 100, message = "Company name must be between 2 and 100 characters")
    private String companyName;

    @NotBlank(message = "Contact person is required")
    @Size(min = 2, max = 100, message = "Contact person must be between 2 and 100 characters")
    private String contactPerson;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^\\+?[1-9]\\d{1,14}$", message = "Invalid phone number format")
    private String phoneNumber;

    @NotBlank(message = "Category is required")
    private String category;

    private boolean active = true;

    @Size(max = 500, message = "Address cannot exceed 500 characters")
    private String address;

    @Size(max = 200, message = "Website cannot exceed 200 characters")
    private String website;

    @Size(max = 1000, message = "Notes cannot exceed 1000 characters")
    private String notes;
} 