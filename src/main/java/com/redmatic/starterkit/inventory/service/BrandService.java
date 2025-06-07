package com.redmatic.starterkit.inventory.service;

import com.redmatic.starterkit.inventory.dto.request.BrandRequestDTO;
import com.redmatic.starterkit.inventory.dto.BrandResponseDTO;
import com.redmatic.starterkit.inventory.entity.Brand;
import com.redmatic.starterkit.inventory.exception.ResourceNotFoundException;
import com.redmatic.starterkit.inventory.repository.BrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BrandService {

    private final BrandRepository brandRepository;

    @Transactional(readOnly = true)
    public List<BrandResponseDTO> getAllBrands() {
        return brandRepository.findAll()
                .stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public BrandResponseDTO getBrandById(Long id) {
        Brand brand = brandRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Brand not found with id: " + id));
        return convertToResponseDTO(brand);
    }

    @Transactional
    public BrandResponseDTO createBrand(BrandRequestDTO request) {
        Brand brand = new Brand();
        brand.setName(request.getName());
        brand.setDescription(request.getDescription());
        brand.setStatus(request.getStatus());
        brand.setIsActive(request.getIsActive() != null ? request.getIsActive() : true);
        brand.setCreatedAt(LocalDateTime.now());
        brand.setUpdatedAt(LocalDateTime.now());

        Brand savedBrand = brandRepository.save(brand);
        return convertToResponseDTO(savedBrand);
    }

    @Transactional
    public BrandResponseDTO updateBrandById(Long id, BrandRequestDTO request) {
        Brand existingBrand = brandRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Brand not found with id: " + id));

        if (request.getName() != null) {
            existingBrand.setName(request.getName());
        }
        if (request.getDescription() != null) {
            existingBrand.setDescription(request.getDescription());
        }
        if (request.getStatus() != null) {
            existingBrand.setStatus(request.getStatus());
        }
        if (request.getIsActive() != null) {
            existingBrand.setIsActive(request.getIsActive());
        }

        existingBrand.setUpdatedAt(LocalDateTime.now());
        Brand updatedBrand = brandRepository.save(existingBrand);
        return convertToResponseDTO(updatedBrand);
    }

    @Transactional
    public void deleteBrandById(Long id) {
        if (!brandRepository.existsById(id)) {
            throw new ResourceNotFoundException("Brand not found with id: " + id);
        }
        brandRepository.deleteById(id);
    }

    private BrandResponseDTO convertToResponseDTO(Brand brand) {
        return BrandResponseDTO.builder()
                .id(brand.getId())
                .name(brand.getName())
                .description(brand.getDescription())
                .status(brand.getStatus())
                .isActive(brand.getIsActive())
                .createdAt(brand.getCreatedAt())
                .updatedAt(brand.getUpdatedAt())
                .build();
    }
}