package com.redmatic.autotab.inventory.dto;

import lombok.*;

@Data
@Builder
public class CategoryResponseDTO {
    private Long id;
    private String name;
    private String description;
}
