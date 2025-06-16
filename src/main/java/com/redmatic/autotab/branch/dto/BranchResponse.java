package com.redmatic.autotab.branch.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class BranchResponse {
    private Long id;
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
    private LocalDateTime createdAt;
}
