package com.redmatic.autotab.inventory.repository;

import com.redmatic.autotab.inventory.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long> {
}
