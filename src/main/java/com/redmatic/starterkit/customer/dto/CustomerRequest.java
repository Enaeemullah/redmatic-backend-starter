package com.redmatic.starterkit.customer.dto;

import lombok.Data;

@Data
public class CustomerRequest {
    private String fullName;
    private String email;
    private String phone;
    private String address;
    private String city;
    private String state;
    private String country;
    private String postalCode;
    private String companyName;
    private String gstNumber;
}
