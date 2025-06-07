package com.redmatic.starterkit.branch.controller;

import com.redmatic.starterkit.branch.dto.BranchRequest;
import com.redmatic.starterkit.branch.dto.BranchResponse;
import com.redmatic.starterkit.branch.service.BranchService;
import com.redmatic.starterkit.constants.ApiURI;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiURI.API_BASE_PATH)
@RequiredArgsConstructor
public class BranchController {

    private final BranchService branchService;

    @PostMapping(ApiURI.CREATE_BRANCHES)
    public ResponseEntity<BranchResponse> create(@Valid @RequestBody BranchRequest request) {
        return ResponseEntity.ok(branchService.createBranch(request));
    }

    @GetMapping(ApiURI.GET_ALL_BRANCHES)
    public ResponseEntity<List<BranchResponse>> getAllBranches() {
        return ResponseEntity.ok(branchService.getAllBranches());
    }

    @GetMapping(ApiURI.GET_BRANCH_GET_BY_ID)
    public ResponseEntity<BranchResponse> getBranchById(@PathVariable Long id) {
        return ResponseEntity.ok(branchService.getBranchById(id));
    }

    @PutMapping(ApiURI.UPDATE_BRANCH_BY_ID)
    public ResponseEntity<BranchResponse> update(@PathVariable Long id, @Valid @RequestBody BranchRequest request) {
        return ResponseEntity.ok(branchService.updateBranch(id, request));
    }

    @DeleteMapping(ApiURI.DELETE_BRANCH_BY_ID)
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        branchService.deleteBranch(id);
        return ResponseEntity.noContent().build();
    }
}
