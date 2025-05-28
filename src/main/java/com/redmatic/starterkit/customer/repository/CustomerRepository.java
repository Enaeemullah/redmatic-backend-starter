package com.redmatic.starterkit.customer.repository;

import com.redmatic.starterkit.customer.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
