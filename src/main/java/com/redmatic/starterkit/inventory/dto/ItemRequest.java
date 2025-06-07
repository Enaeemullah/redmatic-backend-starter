package com.redmatic.starterkit.inventory.dto;

import lombok.Data;

@Data
public class ItemRequest {
    private String name;
    private String barcode;
    private Double sellingPrice;
    private Double costPrice;
    private String sku;
    private String brand;
    private String description;
    private Integer quantity;  // Changed from stockQuantity to match entity
    private Integer reorderLevel;  // Added to match entity
    private Long categoryId;
    private String unit;
    private Boolean isActive;
}