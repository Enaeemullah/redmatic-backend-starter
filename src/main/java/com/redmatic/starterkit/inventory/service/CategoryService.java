package com.redmatic.starterkit.inventory.service;

import com.redmatic.starterkit.inventory.dto.CategoryRequest;
import com.redmatic.starterkit.inventory.dto.CategoryResponse;
import com.redmatic.starterkit.inventory.entity.Category;
import com.redmatic.starterkit.inventory.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryResponse createCategory(CategoryRequest request) {
        if (categoryRepository.existsByTitle(request.getTitle())) {
            throw new IllegalArgumentException("Category with this title already exists.");
        }

        Category category = Category.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .build();

        Category saved = categoryRepository.save(category);

        return CategoryResponse.builder()
                .id(saved.getId())
                .title(saved.getTitle())
                .description(saved.getDescription())
                .build();
    }
}
