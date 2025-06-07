package com.redmatic.starterkit.inventory.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.redmatic.starterkit.auth.dto.AuthResponse;
import com.redmatic.starterkit.auth.dto.LoginRequest;
import com.redmatic.starterkit.constants.ApiURI;
import com.redmatic.starterkit.constants.AppConstants;
import com.redmatic.starterkit.inventory.dto.ItemRequest;
import com.redmatic.starterkit.inventory.dto.ItemResponse;
import com.redmatic.starterkit.inventory.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping(ApiURI.API_BASE_PATH)
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @PostMapping(ApiURI.INVENTORY_ITEM_CREATE)
    public ResponseEntity<ItemResponse> createItem(@RequestBody ItemRequest request) {
        return ResponseEntity.ok(itemService.createItem(request));
    }

    @GetMapping(ApiURI.GET_INVENTORY_ITEMS)
    public ResponseEntity<List<ItemResponse>> getItems() {
        return ResponseEntity.ok(itemService.getAllItems());
    }

    @GetMapping(ApiURI.INVENTORY_ITEM_GET_BY_ID)
    public ResponseEntity<ItemResponse> getItemById(@PathVariable Long id) {
        return ResponseEntity.ok(itemService.getItemById(id));
    }

    @PutMapping(ApiURI.UPDATE_INVENTORY_ITEM_GET_BY_ID)
    public ResponseEntity<ItemResponse> updateItem(@PathVariable Long id, @RequestBody ItemRequest request) {
        return ResponseEntity.ok(itemService.updateItemById(id, request));
    }

    @DeleteMapping(ApiURI.DELETE_INVENTORY_ITEM_GET_BY_ID)
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        itemService.deleteItemById(id);
        return ResponseEntity.noContent().build();
    }
}
