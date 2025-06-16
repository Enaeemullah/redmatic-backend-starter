package com.redmatic.autotab.organization.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class OrganizationSignupRequest {
    @NotBlank
    private String orga_desc;

    @NotBlank
    private String orga_code;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String phoneNo;

    @NotBlank
    private String password;

}
