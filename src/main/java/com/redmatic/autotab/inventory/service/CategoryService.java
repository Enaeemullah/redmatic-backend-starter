package com.redmatic.autotab.inventory.service;

import com.redmatic.autotab.inventory.dto.CategoryRequestDTO;
import com.redmatic.autotab.inventory.dto.CategoryResponseDTO;
import com.redmatic.autotab.inventory.entity.Category;
import com.redmatic.autotab.inventory.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryResponseDTO createCategory(CategoryRequestDTO request) {
        if (categoryRepository.existsByName(request.getName())) {
            throw new IllegalArgumentException("Category with this title already exists.");
        }

        Category category = Category.builder()
                .name(request.getName())
                .description(request.getDescription())
                .status(request.getStatus())
                .build();

        Category saved = categoryRepository.save(category);

        return CategoryResponseDTO.builder()
                .id(saved.getId())
                .name(saved.getName())
                .description(saved.getDescription())
                .build();
    }

    public List<CategoryResponseDTO> getAllCategories() {
        return categoryRepository.findAll().stream()
                .map(category -> CategoryResponseDTO.builder()
                        .id(category.getId())
                        .name(category.getName())
                        .description(category.getDescription())
                        .build())
                .collect(Collectors.toList());
    }

}
