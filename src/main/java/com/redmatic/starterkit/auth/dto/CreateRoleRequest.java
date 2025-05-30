package com.redmatic.starterkit.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateRoleRequest {
    private String name;
    private String description;
    private List<Long> permissionIds; // from selected checkboxes
}
