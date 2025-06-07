package com.redmatic.starterkit.inventory.dto;

import lombok.*;

@Data
@Builder
public class CategoryResponseDTO {
    private Long id;
    private String name;
    private String description;
}
