package com.redmatic.autotab.auth.repository;

import com.redmatic.autotab.auth.entity.RedModule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RedModuleRepository extends JpaRepository<RedModule, Long> {
    Optional<RedModule> findByName(String name);
}