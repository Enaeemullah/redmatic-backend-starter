package com.redmatic.starterkit.organization.service.impl;

import com.redmatic.starterkit.auth.entity.Role;
import com.redmatic.starterkit.auth.entity.User;
import com.redmatic.starterkit.auth.repository.RoleRepository;
import com.redmatic.starterkit.auth.repository.UserRepository;
import com.redmatic.starterkit.constants.ApiCode;
import com.redmatic.starterkit.core.exception.BaseException;
import com.redmatic.starterkit.organization.dto.OrganizationSignupRequest;
import com.redmatic.starterkit.organization.entity.Organization;
import com.redmatic.starterkit.organization.repository.OrganizationRepository;
import com.redmatic.starterkit.organization.service.OrganizationService;
import com.redmatic.starterkit.util.PasswordUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationRepository organizationRepository;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Transactional
    @Override
    public void signupWithAdmin(OrganizationSignupRequest request) {
        if (organizationRepository.existsByOrgaCode(request.getOrga_code())) {
            throw new BaseException(ApiCode.ORG_CODE_EXISTS);
        }

        // Save Organization
        Organization organization = organizationRepository.save(
                Organization.builder()
                        .orgaCode(request.getOrga_code())
                        .orgaDesc(request.getOrga_desc())
                        .createdAt(LocalDateTime.now())
                        .updatedAt(LocalDateTime.now())
                        .build()
        );

        // Get Admin Role
        Role adminRole = roleRepository.findByName("ROLE_ADMIN")
                .orElseThrow(() -> new BaseException(ApiCode.INVALID_REQUEST)); // You can define a better code here

        // Save Admin User
        userRepository.save(User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .phoneNo(request.getPhoneNo())
                .password(PasswordUtil.encode(request.getPassword()))
                .organization(organization)
                .role(adminRole)
                .build());
    }
}
