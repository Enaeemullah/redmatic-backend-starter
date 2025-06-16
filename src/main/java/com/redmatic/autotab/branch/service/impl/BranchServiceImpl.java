package com.redmatic.autotab.branch.service.impl;

import com.redmatic.autotab.branch.dto.BranchRequest;
import com.redmatic.autotab.branch.dto.BranchResponse;
import com.redmatic.autotab.branch.entity.Branch;
import com.redmatic.autotab.branch.repository.BranchRepository;
import com.redmatic.autotab.branch.service.BranchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BranchServiceImpl implements BranchService {

    private final BranchRepository branchRepository;

    @Override
    public BranchResponse createBranch(BranchRequest request) {
        Branch branch = Branch.builder()
                .name(request.getName())
                .email(request.getEmail())
                .phone(request.getPhone())
                .country(request.getCountry())
                .city(request.getCity())
                .state(request.getState())
                .code(request.getCode())
                .zipCode(request.getZipCode())
                .address(request.getAddress())
                .build();
        Branch saved = branchRepository.save(branch);
        return toResponse(saved);
    }

    @Override
    public List<BranchResponse> getAllBranches() {
        return branchRepository.findAll()
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public BranchResponse getBranchById(Long id) {
        return branchRepository.findById(id)
                .map(this::toResponse)
                .orElseThrow(() -> new RuntimeException("Branch not found"));
    }

    @Override
    public BranchResponse updateBranch(Long id, BranchRequest request) {
        Branch branch = branchRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Branch not found"));
        branch.setName(request.getName());
        branch.setCity(request.getCity());
        branch.setCode(request.getCode());
        branch.setCountry(request.getCountry());
        branch.setState(request.getState());
        branch.setZipCode(request.getZipCode());
        branch.setStatus(request.getStatus());
        branch.setPhone(request.getPhone());
        branch.setEmail(request.getEmail());
        branch.setAddress(request.getAddress());
        return toResponse(branchRepository.save(branch));
    }

    @Override
    public void deleteBranch(Long id) {
        branchRepository.deleteById(id);
    }

    private BranchResponse toResponse(Branch branch) {
        return BranchResponse.builder()
                .id(branch.getId())
                .name(branch.getName())
                .city(branch.getCity())
                .code(branch.getCode())
                .state(branch.getState())
                .zipCode(branch.getZipCode())
                .country(branch.getCountry())
                .phone(branch.getPhone())
                .email(branch.getEmail())
                .address(branch.getAddress())
                .createdAt(branch.getCreatedAt())
                .build();
    }
}
