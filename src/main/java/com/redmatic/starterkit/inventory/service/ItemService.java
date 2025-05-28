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

    public ItemResponse addItem(ItemRequest request, MultipartFile image) {
        Category category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new NotFoundException(CATEGORY_NOT_FOUND));

        String imageUrl = image != null && !image.isEmpty() ? minioService.uploadFile(image) : null;

        Item item = Item.builder()
                .name(request.getName())
                .sellingPrice(request.getSellingPrice())
                .costPrice(request.getCostPrice())
                .sku(request.getSku())
                .description(request.getDescription())
                .quantity(request.getStockQuantity())
                .category(category)
                .imageUrl(imageUrl)
                .build();

        itemRepository.save(item);
        return toResponse(item);
    }

    public List<ItemResponse> getAllItems() {
        return itemRepository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
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
