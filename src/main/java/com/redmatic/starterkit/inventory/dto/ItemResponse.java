package com.redmatic.starterkit.inventory.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ItemResponse {
    private Long id;
    private String name;
    private Double sellingPrice;
    private Double costPrice;
    private String sku;
    private String brand;
    private String description;
    private Integer stockQuantity;
    private String imageUrl;
    private Long categoryId;
    private String categoryTitle;
}
