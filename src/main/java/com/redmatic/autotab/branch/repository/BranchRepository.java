package com.redmatic.autotab.branch.repository;

import com.redmatic.autotab.branch.entity.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchRepository extends JpaRepository<Branch, Long> {
}
