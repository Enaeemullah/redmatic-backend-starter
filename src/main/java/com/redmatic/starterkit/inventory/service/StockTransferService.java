package com.redmatic.starterkit.inventory.service;

import com.redmatic.starterkit.branch.entity.Branch;
import com.redmatic.starterkit.branch.repository.BranchRepository;
import com.redmatic.starterkit.inventory.dto.*;
import com.redmatic.starterkit.inventory.entity.Item;
import com.redmatic.starterkit.inventory.exception.*;
import com.redmatic.starterkit.inventory.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class StockTransferService {

    private final ItemRepository itemRepository;
    private final BranchRepository branchRepository;

    @Transactional
    public StockTransferResponse transferStock(StockTransferDTO request) {
        log.info("Initiating stock transfer: {}", request);

        // Validate request
        validateTransferRequest(request);

        // Get source item
        Item sourceItem = getSourceItem(request);

        // Check stock availability
        verifyStockAvailability(sourceItem, request.getQuantity());

        // Process transfer
        Item destinationItem = getOrCreateDestinationItem(request, sourceItem);
        updateItemQuantities(sourceItem, destinationItem, request.getQuantity());

        // Build and return response
        return buildSuccessResponse(request, sourceItem, destinationItem);
    }

    private void validateTransferRequest(StockTransferDTO request) {
        if (request.getSourceBranchId().equals(request.getDestinationBranchId())) {
            throw new InvalidTransferException("Cannot transfer to the same branch");
        }
        if (request.getQuantity() <= 0) {
            throw new InvalidTransferException("Transfer quantity must be positive");
        }
        if (!branchRepository.existsById(request.getSourceBranchId())) {
            throw new InvalidTransferException("Source branch not found");
        }
        if (!branchRepository.existsById(request.getDestinationBranchId())) {
            throw new InvalidTransferException("Destination branch not found");
        }
    }

    private Item getSourceItem(StockTransferDTO request) {
        return itemRepository.findByIdAndBranchId(request.getItemId(), request.getSourceBranchId())
                .orElseThrow(() -> new ItemNotFoundException(
                        request.getItemId(),
                        request.getSourceBranchId()
                ));
    }

    private void verifyStockAvailability(Item item, int quantity) {
        if (item.getQuantity() < quantity) {
            throw new InsufficientStockException(item.getQuantity(), quantity);
        }
    }

    private Item getOrCreateDestinationItem(StockTransferDTO request, Item sourceItem) {
        return itemRepository.findByIdAndBranchId(request.getItemId(), request.getDestinationBranchId())
                .orElseGet(() -> {
                    log.info("Creating new item instance in destination branch {}", request.getDestinationBranchId());
                    return createDestinationItem(sourceItem, request.getDestinationBranchId());
                });
    }

    private Item createDestinationItem(Item sourceItem, Long destinationBranchId) {
        Branch destinationBranch = branchRepository.findById(destinationBranchId)
                .orElseThrow(() -> new InvalidTransferException("Destination branch not found"));

        return Item.builder()
                .name(sourceItem.getName())
                .description(sourceItem.getDescription())
                .sellingPrice(sourceItem.getSellingPrice())
                .costPrice(sourceItem.getCostPrice())
                .sku(sourceItem.getSku())
                .barcode(sourceItem.getBarcode())
                .quantity(0)
                .reorderLevel(sourceItem.getReorderLevel())
                .unit(sourceItem.getUnit())
                .brand(sourceItem.getBrand())
                .imageUrl(sourceItem.getImageUrl())
                .isActive(true)
                .category(sourceItem.getCategory())
                .branch(destinationBranch)
                .build();
    }

    private void updateItemQuantities(Item source, Item destination, int quantity) {
        source.setQuantity(source.getQuantity() - quantity);
        destination.setQuantity(destination.getQuantity() + quantity);
        log.info("Updated quantities - Source: {}, Destination: {}",
                source.getQuantity(), destination.getQuantity());
    }

    private StockTransferResponse buildSuccessResponse(StockTransferDTO request,
                                                       Item sourceItem,
                                                       Item destinationItem) {
        String message = String.format(
                "Successfully transferred %d units of %s from branch %d to branch %d",
                request.getQuantity(),
                sourceItem.getName(),
                request.getSourceBranchId(),
                request.getDestinationBranchId()
        );

        log.info(message);

        return StockTransferResponse.builder()
                .success(true)
                .message(message)
                .sourceItem(mapToItemResponse(sourceItem))
                .destinationItem(mapToItemResponse(destinationItem))
                .transferredQuantity(request.getQuantity())
                .build();
    }

    private ItemResponse mapToItemResponse(Item item) {
        return ItemResponse.builder()
                .id(item.getId())
                .name(item.getName())
                .sellingPrice(item.getSellingPrice())
                .costPrice(item.getCostPrice())
                .sku(item.getSku())
                .brandId(item.getBrand() != null ? item.getBrand().getId() : null)
                .brandName(item.getBrand() != null ? item.getBrand().getName() : null)
                .description(item.getDescription())
                .stockQuantity(item.getQuantity())
                .imageUrl(item.getImageUrl())
                .categoryId(item.getCategory() != null ? item.getCategory().getId() : null)
                .categoryName(item.getCategory() != null ? item.getCategory().getName() : null)
                .build();
    }
}