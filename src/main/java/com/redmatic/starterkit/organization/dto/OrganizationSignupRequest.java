package com.redmatic.starterkit.organization.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class OrganizationSignupRequest {
    @NotBlank
    private String organizationName;

    @NotBlank
    private String porOrgacode;

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
