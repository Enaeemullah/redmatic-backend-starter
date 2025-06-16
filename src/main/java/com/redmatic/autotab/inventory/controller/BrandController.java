package com.redmatic.autotab.inventory.controller;

import com.redmatic.autotab.constants.ApiURI;
import com.redmatic.autotab.inventory.dto.BrandResponseDTO;
import com.redmatic.autotab.inventory.service.BrandService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiURI.API_BASE_PATH)
public class BrandController {

    private final BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @PostMapping(ApiURI.CREATE_BRANDS)
    public ResponseEntity<BrandResponseDTO> createBrand(@RequestBody com.redmatic.autotab.inventory.dto.request.BrandRequestDTO request) {
        return ResponseEntity.ok(brandService.createBrand(request));
    }

    @GetMapping(ApiURI.GET_ALL_BRANDS)
    public ResponseEntity<List<BrandResponseDTO>> getBrands() {
        return ResponseEntity.ok(brandService.getAllBrands());
    }

    @PutMapping(ApiURI.UPDATE_BRANDS_GET_BY_ID)
    public ResponseEntity<BrandResponseDTO> updateBrand(@PathVariable Long id, @RequestBody com.redmatic.autotab.inventory.dto.request.BrandRequestDTO request) {
        return ResponseEntity.ok(brandService.updateBrandById(id, request));
    }

    @DeleteMapping(ApiURI.DELETE_BRANDS_ITEM_GET_BY_ID)
    public ResponseEntity<Void> deleteBrand(@PathVariable Long id) {
        brandService.deleteBrandById(id);
        return ResponseEntity.noContent().build();
    }
}
