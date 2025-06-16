package com.redmatic.autotab.auth.repository;

import com.redmatic.autotab.auth.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String username);
    boolean existsByEmail(String email);
    boolean existsByPhoneNo(String phoneNo);
}
