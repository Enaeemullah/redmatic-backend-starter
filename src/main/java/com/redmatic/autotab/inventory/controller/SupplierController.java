package com.redmatic.autotab.inventory.controller;

import com.redmatic.autotab.constants.ApiURI;
import com.redmatic.autotab.inventory.dto.SupplierRequestDTO;
import com.redmatic.autotab.inventory.dto.SupplierResponseDTO;
import com.redmatic.autotab.inventory.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiURI.API_BASE_PATH)
@RequiredArgsConstructor
public class SupplierController {

    private final SupplierService supplierService;

    @PostMapping(ApiURI.CREATE_SUPPLIER)
    public ResponseEntity<SupplierResponseDTO> createSupplier(@RequestBody SupplierRequestDTO request) {
        return ResponseEntity.ok(supplierService.createSupplier(request));
    }

    @GetMapping(ApiURI.GET_ALL_SUPPLIER)
    public ResponseEntity<List<SupplierResponseDTO>> getItems() {
        return ResponseEntity.ok(supplierService.getAllItems());
    }

    @PutMapping(ApiURI.UPDATE_SUPPLIER_GET_BY_ID)
    public ResponseEntity<SupplierResponseDTO> updateItem(@PathVariable Long id, @RequestBody SupplierRequestDTO request) {
        return ResponseEntity.ok(supplierService.updateSupplierById(id, request));
    }

    @DeleteMapping(ApiURI.DELETE_SUPPLIER_ITEM_GET_BY_ID)
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        supplierService.deleteSupplierById(id);
        return ResponseEntity.noContent().build();
    }

}
