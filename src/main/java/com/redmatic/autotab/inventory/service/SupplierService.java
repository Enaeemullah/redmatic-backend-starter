package com.redmatic.autotab.inventory.service;

import com.redmatic.autotab.core.exception.NotFoundException;
import com.redmatic.autotab.inventory.dto.SupplierRequestDTO;
import com.redmatic.autotab.inventory.dto.SupplierResponseDTO;
import com.redmatic.autotab.inventory.entity.Supplier;
import com.redmatic.autotab.inventory.exception.DuplicateResourceException;
import com.redmatic.autotab.inventory.repository.SupplierRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SupplierService {

    private final SupplierRepository supplierRepository;

    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Transactional
    public SupplierResponseDTO createSupplier(SupplierRequestDTO request) {
        // Validate request
        if (request == null) {
            throw new IllegalArgumentException("Supplier request cannot be null");
        }

        // Check for duplicate email or phone
        if (supplierRepository.existsByEmail(request.getEmail())) {
            throw new DuplicateResourceException(
                    "Supplier with email '" + request.getEmail() + "' already exists");
        }

        if (supplierRepository.existsByPhone(request.getPhone())) {
            throw new DuplicateResourceException(
                    "Supplier with phone '" + request.getPhone() + "' already exists");
        }

        // Map DTO to Entity
        Supplier supplier = mapDtoToEntity(request);

        // Save to database
        Supplier savedSupplier = supplierRepository.save(supplier);

        // Map Entity to Response DTO
        return mapEntityToResponse(savedSupplier);
    }

    private Supplier mapDtoToEntity(SupplierRequestDTO dto) {
        return Supplier.builder()
                .address(dto.getAddress())
                .city(dto.getCity())
                .contactPerson(dto.getContactPerson())
                .country(dto.getCountry())
                .email(dto.getEmail())
                .name(dto.getName())
                .notes(dto.getNotes())
                .paymentTerms(dto.getPaymentTerms())
                .phone(dto.getPhone())
                .state(dto.getState())
                .status(dto.getStatus())
                .taxId(dto.getTaxId())
                .zipCode(dto.getZipCode())
                .build();
    }

    private SupplierResponseDTO mapEntityToResponse(Supplier supplier) {
        return SupplierResponseDTO.builder()
                .id(supplier.getId())
                .address(supplier.getAddress())
                .city(supplier.getCity())
                .contactPerson(supplier.getContactPerson())
                .country(supplier.getCountry())
                .email(supplier.getEmail())
                .name(supplier.getName())
                .notes(supplier.getNotes())
                .paymentTerms(supplier.getPaymentTerms())
                .phone(supplier.getPhone())
                .state(supplier.getState())
                .status(supplier.getStatus())
                .taxId(supplier.getTaxId())
                .zipCode(supplier.getZipCode())
                .build();
    }

    public List<SupplierResponseDTO> getAllItems() {
        return supplierRepository.findAll().stream()
                .map(this::mapEntityToResponse)
                .collect(Collectors.toList());
    }

    public SupplierResponseDTO updateSupplierById(Long id, SupplierRequestDTO supplierRequestDTO) {
        // Find the existing supplier or throw exception if not found
        Supplier supplier = supplierRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Supplier not found with ID: " + id));

        // Update the supplier fields from the DTO
        supplier.setAddress(supplierRequestDTO.getAddress());
        supplier.setCity(supplierRequestDTO.getCity());
        supplier.setContactPerson(supplierRequestDTO.getContactPerson());
        supplier.setCountry(supplierRequestDTO.getCountry());
        supplier.setEmail(supplierRequestDTO.getEmail());
        supplier.setName(supplierRequestDTO.getName());
        supplier.setNotes(supplierRequestDTO.getNotes());
        supplier.setPaymentTerms(supplierRequestDTO.getPaymentTerms());
        supplier.setPhone(supplierRequestDTO.getPhone());
        supplier.setState(supplierRequestDTO.getState());
        supplier.setStatus(supplierRequestDTO.getStatus());
        supplier.setTaxId(supplierRequestDTO.getTaxId());
        supplier.setZipCode(supplierRequestDTO.getZipCode());

        // Save the updated supplier
        Supplier updatedSupplier = supplierRepository.save(supplier);

        // Convert to SupplierResponseDTO and return
        return toSupplierResponseDTO(updatedSupplier);
    }

    private SupplierResponseDTO toSupplierResponseDTO(Supplier supplier) {
        return SupplierResponseDTO.builder()
                .id(supplier.getId())
                .address(supplier.getAddress())
                .city(supplier.getCity())
                .contactPerson(supplier.getContactPerson())
                .country(supplier.getCountry())
                .email(supplier.getEmail())
                .name(supplier.getName())
                .notes(supplier.getNotes())
                .paymentTerms(supplier.getPaymentTerms())
                .phone(supplier.getPhone())
                .state(supplier.getState())
                .status(supplier.getStatus())
                .taxId(supplier.getTaxId())
                .zipCode(supplier.getZipCode())
                .build();
    }

    public void deleteSupplierById(Long id) {
        Supplier supplier = supplierRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Supplier not found with ID: " + id));
        supplierRepository.delete(supplier);
    }
}