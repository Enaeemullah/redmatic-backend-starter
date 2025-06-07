package com.redmatic.starterkit.inventory.repository;

import com.redmatic.starterkit.inventory.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long> {
}
