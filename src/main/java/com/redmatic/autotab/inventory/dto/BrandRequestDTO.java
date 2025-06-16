package com.redmatic.autotab.inventory.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BrandRequestDTO {

    @NotBlank(message = "Brand name is required")
    private String name;

    private String description;

    @NotBlank(message = "Status is required")
    private String status;

    private Boolean isActive;
}