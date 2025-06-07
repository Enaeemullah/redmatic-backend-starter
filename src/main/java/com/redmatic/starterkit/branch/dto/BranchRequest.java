package com.redmatic.starterkit.branch.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class BranchRequest {

    private String name;
    private String phone;
    private String email;
    private String address;
    private String city;
    private String code;
    private String status;
    private String state;
    private String zipCode;
    private String country;
}
