package com.redmatic.autotab.inventory.controller;

import com.redmatic.autotab.constants.ApiURI;
import com.redmatic.autotab.inventory.dto.ItemRequest;
import com.redmatic.autotab.inventory.dto.ItemResponse;
import com.redmatic.autotab.inventory.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
