package com.redmatic.starterkit.organization.repository;

import com.redmatic.starterkit.organization.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {
    Optional<Organization> findByOrgaCode(String code);
    boolean existsByOrgaCode(String orgaCode);
}
