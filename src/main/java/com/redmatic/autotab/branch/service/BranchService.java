package com.redmatic.autotab.branch.service;

import com.redmatic.autotab.branch.dto.BranchRequest;
import com.redmatic.autotab.branch.dto.BranchResponse;

import java.util.List;

public interface BranchService {
    BranchResponse createBranch(BranchRequest request);
    List<BranchResponse> getAllBranches();
    BranchResponse getBranchById(Long id);
    BranchResponse updateBranch(Long id, BranchRequest request);
    void deleteBranch(Long id);
}
