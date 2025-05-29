package com.redmatic.starterkit.pos.repository;

import com.redmatic.starterkit.pos.entity.SaleTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleTransactionRepository extends JpaRepository<SaleTransaction, Long> {
}