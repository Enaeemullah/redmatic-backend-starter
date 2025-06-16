package com.redmatic.autotab.customer.repository;

import com.redmatic.autotab.customer.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
