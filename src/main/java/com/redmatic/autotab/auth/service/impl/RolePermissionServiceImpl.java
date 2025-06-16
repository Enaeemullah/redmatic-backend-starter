package com.redmatic.autotab.auth.service.impl;

import com.redmatic.autotab.auth.dto.RolePermissionRequest;
import com.redmatic.autotab.auth.entity.Action;
import com.redmatic.autotab.auth.entity.Permission;
import com.redmatic.autotab.auth.entity.RedModule;
import com.redmatic.autotab.auth.entity.Role;
import com.redmatic.autotab.auth.repository.*;
import com.redmatic.autotab.auth.service.RolePermissionService;
import com.redmatic.autotab.core.exception.BaseException;
import com.redmatic.autotab.constants.ApiCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class RolePermissionServiceImpl implements RolePermissionService {

    private final RoleRepository roleRepository;
    private final RedModuleRepository moduleRepository;
    private final ActionRepository actionRepository;
    private final PermissionRepository permissionRepository;

    @Override
    @Transactional
    public void assignPermissions(RolePermissionRequest request) {
        Role role = roleRepository.findByName(request.getRoleName())
                .orElseThrow(() -> new BaseException(ApiCode.ROLE_NOT_FOUND));

        RedModule redModule = moduleRepository.findByName(request.getModuleName())
                .orElseThrow(() -> new BaseException(ApiCode.MODULE_NOT_FOUND));

        Set<Permission> permissions = new HashSet<>();

        request.getActions().forEach((actionName, isSelected) -> {
            if (Boolean.TRUE.equals(isSelected)) {
                Action action = actionRepository.findByName(actionName.toUpperCase())
                        .orElseThrow(() -> new BaseException(ApiCode.ACTION_NOT_FOUND));

                permissionRepository.findByRedModuleAndAction(redModule, action)
                        .ifPresent(permissions::add);
            }
        });

        role.setPermissions(permissions);
        roleRepository.save(role);
    }
}
