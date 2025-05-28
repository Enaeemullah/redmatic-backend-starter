package com.redmatic.starterkit.inventory.repository;

import com.redmatic.starterkit.inventory.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
    boolean existsBySku(String sku);
}
