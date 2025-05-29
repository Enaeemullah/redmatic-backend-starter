package com.redmatic.starterkit.pos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class SaleTransactionResponse {
    private String transactionId;
    private Long itemId;
    private String itemName;
    private Integer quantity;
    private BigDecimal price;
    private BigDecimal total;
    private LocalDateTime createdAt;
    private Long customerId;
}