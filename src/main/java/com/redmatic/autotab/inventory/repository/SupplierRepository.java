package com.redmatic.autotab.inventory.repository;

import com.redmatic.autotab.inventory.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
    boolean existsByEmail(String email);

    boolean existsByPhone(String phone);
}
