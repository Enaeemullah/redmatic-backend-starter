package com.redmatic.starterkit.inventory.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "suppliers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String city;

    @Column(name = "contact_person", nullable = false)
    private String contactPerson;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String notes;

    @Column(name = "payment_terms", nullable = false)
    private String paymentTerms;

    @Column(nullable = false, unique = true)
    private String phone;

    @Column(nullable = false)
    private String state;

    @Column(nullable = false)
    private String status; // Consider using Enum here

    @Column(name = "tax_id")
    private String taxId;

    @Column(name = "zip_code", nullable = false)
    private String zipCode;
}