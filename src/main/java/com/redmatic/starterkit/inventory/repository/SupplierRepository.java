package com.redmatic.starterkit.inventory.repository;

import com.redmatic.starterkit.inventory.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
    boolean existsByEmail(String email);

    boolean existsByPhone(String phone);
}
