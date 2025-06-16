package com.redmatic.autotab.pos.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class SaleTransactionRequest {
    private Long itemId;
    private String itemName;
    private Integer quantity;
    private BigDecimal price;
    private BigDecimal total;
}