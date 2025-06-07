package com.redmatic.starterkit.inventory.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SupplierResponseDTO {
    private Long id;
    private String address;

    private String city;

    private String contactPerson;

    private String country;

    private String email;

    private String name;

    private String notes;

    private String paymentTerms;

    private String phone;

    private String state;

    private String status;

    private String taxId;

    private String zipCode;
}
