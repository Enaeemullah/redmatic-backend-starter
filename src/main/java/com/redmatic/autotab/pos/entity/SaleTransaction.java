package com.redmatic.autotab.pos.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
public class SaleTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String transactionId;
    private Long itemId;
    private String itemName;
    private Integer quantity;
    private BigDecimal price;
    private BigDecimal total;
    private LocalDateTime createdAt;
    private Long customerId;
}