package com.redmatic.starterkit.branch.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class BranchResponse {
    private Long id;
    private String name;
    private String type;
    private String phone;
    private String email;
    private String address;
    private LocalDateTime createdAt;
}
