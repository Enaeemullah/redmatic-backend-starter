package com.redmatic.starterkit.inventory.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StockTransferResponse {
    private boolean success;
    private String message;
    private ItemResponse sourceItem;
    private ItemResponse destinationItem;
    private int transferredQuantity;
}