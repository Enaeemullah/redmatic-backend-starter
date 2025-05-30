package com.redmatic.starterkit.auth.repository;

import com.redmatic.starterkit.auth.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {
    // Custom queries (if any) can go here
}
