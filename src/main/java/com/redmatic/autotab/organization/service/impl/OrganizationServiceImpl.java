package com.redmatic.autotab.organization.service.impl;

import com.redmatic.autotab.auth.entity.Role;
import com.redmatic.autotab.auth.entity.User;
import com.redmatic.autotab.auth.repository.RoleRepository;
import com.redmatic.autotab.auth.repository.UserRepository;
import com.redmatic.autotab.constants.ApiCode;
import com.redmatic.autotab.core.exception.BaseException;
import com.redmatic.autotab.organization.dto.OrganizationSignupRequest;
import com.redmatic.autotab.organization.entity.Organization;
import com.redmatic.autotab.organization.repository.OrganizationRepository;
import com.redmatic.autotab.organization.service.OrganizationService;
import com.redmatic.autotab.util.PasswordUtil;
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

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new BaseException(ApiCode.USER_EMAIL_ALREADY_EXISTS);
        }

        if (userRepository.existsByPhoneNo(request.getPhoneNo())) {
            throw new BaseException(ApiCode.USER_PHONE_ALREADY_EXISTS);
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

        Role adminRole = roleRepository.findByName("ROLE_ADMIN")
                .orElseGet(() -> {
                    Role role = Role.builder()
                            .name("ROLE_ADMIN")
                            .description("Organization Admin")
                            .createdAt(LocalDateTime.now())
                            .updatedAt(LocalDateTime.now())
                            .build();
                    return roleRepository.save(role);
                });

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
