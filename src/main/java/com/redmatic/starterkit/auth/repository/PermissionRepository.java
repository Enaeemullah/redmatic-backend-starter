package com.redmatic.starterkit.auth.repository;

import com.redmatic.starterkit.auth.entity.Action;
import com.redmatic.starterkit.auth.entity.Permission;
import com.redmatic.starterkit.auth.entity.RedModule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {
    Optional<Permission> findByKeyName(String keyName);
    Optional<Permission> findByRedModuleAndAction(RedModule redModule, Action action);
}
