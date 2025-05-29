package com.redmatic.starterkit.branch.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class BranchRequest {

    @NotBlank(message = "Branch name is required")
    private String name;

    private String type;

    private String phone;

    @Email(message = "Invalid email format")
    private String email;

    private String address;
}
