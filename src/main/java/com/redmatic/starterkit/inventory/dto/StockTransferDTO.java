package com.redmatic.starterkit.inventory.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StockTransferDTO {
    private Long sourceBranchId;
    private Long destinationBranchId;
    private Long itemId;
    private Integer quantity;
    private String notes;
}