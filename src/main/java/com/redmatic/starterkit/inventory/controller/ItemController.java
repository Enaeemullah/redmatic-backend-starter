package com.redmatic.starterkit.inventory.controller;

import com.redmatic.starterkit.constants.AppConstants;
import com.redmatic.starterkit.inventory.dto.ItemRequest;
import com.redmatic.starterkit.inventory.dto.ItemResponse;
import com.redmatic.starterkit.inventory.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping(AppConstants.API_BASE_PATH + "/items")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @PostMapping
    public ResponseEntity<ItemResponse> createItem(
            @RequestPart("item") ItemRequest request,
            @RequestPart("image") MultipartFile image
    ) {
        return ResponseEntity.ok(itemService.addItem(request, image));
    }

    @GetMapping
    public ResponseEntity<List<ItemResponse>> getItems() {
        return ResponseEntity.ok(itemService.getAllItems());
    }
}
