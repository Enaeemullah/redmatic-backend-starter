package com.redmatic.starterkit.inventory.controller;

import com.redmatic.starterkit.constants.ApiURI;
import com.redmatic.starterkit.inventory.dto.CategoryRequestDTO;
import com.redmatic.starterkit.inventory.dto.CategoryResponseDTO;
import com.redmatic.starterkit.inventory.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiURI.API_BASE_PATH)
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping(ApiURI.CREATE_CATEGORIES)
    public ResponseEntity<CategoryResponseDTO> createCategory(@RequestBody CategoryRequestDTO request) {
        return ResponseEntity.ok(categoryService.createCategory(request));
    }

    @GetMapping(ApiURI.GET_ALL_CATEGORIES)
    public ResponseEntity<List<CategoryResponseDTO>> getAllCategories() {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }
}
