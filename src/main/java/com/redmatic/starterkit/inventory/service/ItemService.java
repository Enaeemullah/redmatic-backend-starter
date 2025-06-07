package com.redmatic.starterkit.inventory.service;

import com.redmatic.starterkit.core.exception.NotFoundException;
import com.redmatic.starterkit.core.storage.MinioService;
import com.redmatic.starterkit.inventory.dto.ItemRequest;
import com.redmatic.starterkit.inventory.dto.ItemResponse;
import com.redmatic.starterkit.inventory.entity.Category;
import com.redmatic.starterkit.inventory.entity.Item;
import com.redmatic.starterkit.inventory.repository.CategoryRepository;
import com.redmatic.starterkit.inventory.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

import static com.redmatic.starterkit.constants.ErrorMessages.CATEGORY_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;
    private final CategoryRepository categoryRepository;
    private final MinioService minioService;

    public ItemResponse createItem(ItemRequest request) {
        Category category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new NotFoundException(CATEGORY_NOT_FOUND));

        Item item = Item.builder()
                .name(request.getName())
                .barcode(request.getBarcode())  // Added missing field
                .sellingPrice(request.getSellingPrice())
                .costPrice(request.getCostPrice())
                .sku(request.getSku())
                .brand(request.getBrand())
                .description(request.getDescription())
                .quantity(request.getQuantity() != null ? request.getQuantity() : 0) // Handle null quantity
                .unit(request.getUnit())        // Added missing field
                .reorderLevel(request.getReorderLevel()) // Map reorderPoint to reorderLevel
                .isActive(true)                 // Default value
                .category(category)
                .build();

        Item savedItem = itemRepository.save(item);
        return toResponse(savedItem);
    }

    public List<ItemResponse> getAllItems() {
        return itemRepository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public ItemResponse getItemById(Long id) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Item with ID " + id + " not found"));
        return toResponse(item);
    }

    public ItemResponse updateItemById(Long id, ItemRequest request) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Item not found with ID: " + id));

        Category category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new NotFoundException("Category not found with ID: " + request.getCategoryId()));

        item.setName(request.getName());
        item.setBarcode(request.getBarcode());
        item.setSellingPrice(request.getSellingPrice());
        item.setCostPrice(request.getCostPrice());
        item.setSku(request.getSku());
        item.setBrand(request.getBrand());
        item.setDescription(request.getDescription());
        item.setQuantity(request.getQuantity() != null ? request.getQuantity() : 0);
        item.setUnit(request.getUnit());
        item.setReorderLevel(request.getReorderLevel());
        item.setCategory(category);

        Item updatedItem = itemRepository.save(item);
        return toResponse(updatedItem);
    }

    public void deleteItemById(Long id) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Item not found with ID: " + id));
        itemRepository.delete(item);
    }


    private ItemResponse toResponse(Item item) {
        return ItemResponse.builder()
                .id(item.getId())
                .name(item.getName())
                .sellingPrice(item.getSellingPrice())
                .costPrice(item.getCostPrice())
                .sku(item.getSku())
                .description(item.getDescription())
                .stockQuantity(item.getQuantity())
                .categoryId(item.getCategory().getId())
                .categoryTitle(item.getCategory().getTitle())
                .imageUrl(item.getImageUrl())
                .build();
    }
}
