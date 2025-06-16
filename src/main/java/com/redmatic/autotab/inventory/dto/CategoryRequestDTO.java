package com.redmatic.autotab.inventory.dto;

import lombok.*;

@Data
@Builder
public class CategoryRequestDTO {
    private String name;
    private String status;
    private String description;
}
