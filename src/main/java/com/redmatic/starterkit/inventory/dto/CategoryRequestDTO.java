package com.redmatic.starterkit.inventory.dto;

import lombok.*;

@Data
@Builder
public class CategoryRequestDTO {
    private String name;
    private String status;
    private String description;
}
