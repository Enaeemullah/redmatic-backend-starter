package com.redmatic.autotab.inventory.repository;

import com.redmatic.autotab.inventory.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    boolean existsByName(String name);
}
