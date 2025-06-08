package com.redmatic.starterkit.inventory.repository;

import com.redmatic.starterkit.inventory.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, Long> {
    boolean existsBySku(String sku);

    @Query("SELECT i FROM Item i WHERE i.id = :itemId AND i.branch.id = :branchId")
    Optional<Item> findByIdAndBranchId(@Param("itemId") Long itemId,
                                       @Param("branchId") Long branchId);

}
