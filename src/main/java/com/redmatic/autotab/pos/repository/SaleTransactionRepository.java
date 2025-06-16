package com.redmatic.autotab.pos.repository;

import com.redmatic.autotab.pos.entity.SaleTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleTransactionRepository extends JpaRepository<SaleTransaction, Long> {
}