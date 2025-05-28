package com.redmatic.starterkit.inventory.dto;

import lombok.Data;

@Data
public class ItemRequest {
    private String name;
    private Double sellingPrice;
    private Double costPrice;
    private String sku;
    private String brand;
    private String description;
    private Integer stockQuantity;
    private Long categoryId;
}
