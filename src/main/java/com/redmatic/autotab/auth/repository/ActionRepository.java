package com.redmatic.autotab.auth.repository;

import com.redmatic.autotab.auth.entity.Action;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ActionRepository extends JpaRepository<Action, Long> {
    Optional<Action> findByName(String name);
}
