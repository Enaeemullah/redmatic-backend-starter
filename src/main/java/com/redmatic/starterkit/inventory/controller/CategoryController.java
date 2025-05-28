package com.redmatic.starterkit.inventory.controller;

import com.redmatic.starterkit.inventory.dto.CategoryRequest;
import com.redmatic.starterkit.inventory.dto.CategoryResponse;
import com.redmatic.starterkit.inventory.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<CategoryResponse> createCategory(@RequestBody CategoryRequest request) {
        return ResponseEntity.ok(categoryService.createCategory(request));
    }
}
