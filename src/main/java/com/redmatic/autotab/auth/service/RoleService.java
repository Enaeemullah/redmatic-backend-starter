package com.redmatic.autotab.auth.service;

import com.redmatic.autotab.auth.dto.CreateRoleRequest;
import com.redmatic.autotab.auth.entity.Permission;
import com.redmatic.autotab.auth.entity.Role;
import com.redmatic.autotab.auth.repository.PermissionRepository;
import com.redmatic.autotab.auth.repository.RoleRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;
    private final PermissionRepository permissionRepository;

    @Transactional
    public void createRoleWithPermissions(CreateRoleRequest request) {
        Role role = new Role();
        role.setName(request.getName());
        role.setDescription(request.getDescription());

        List<Permission> permissions = permissionRepository.findAllById(request.getPermissionIds());
        role.setPermissions(new HashSet<>(permissions));

        roleRepository.save(role);
    }
}
