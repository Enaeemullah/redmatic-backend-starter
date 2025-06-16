package com.redmatic.autotab.auth.service.impl;

import com.redmatic.autotab.auth.dto.PermissionRequest;
import com.redmatic.autotab.auth.entity.Action;
import com.redmatic.autotab.auth.entity.Permission;
import com.redmatic.autotab.auth.entity.RedModule;
import com.redmatic.autotab.auth.repository.ActionRepository;
import com.redmatic.autotab.auth.repository.PermissionRepository;
import com.redmatic.autotab.auth.repository.RedModuleRepository;
import com.redmatic.autotab.auth.service.PermissionService;
import com.redmatic.autotab.constants.ApiCode;
import com.redmatic.autotab.core.exception.BaseException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PermissionServiceImpl implements PermissionService {

    private final ActionRepository actionRepository;
    private final RedModuleRepository moduleRepository;
    private final PermissionRepository permissionRepository;

    @Transactional
    @Override
    public void createPermission(PermissionRequest request) {
        RedModule redModule = moduleRepository.findByName(request.getModuleName())
                .orElseThrow(() -> new BaseException(ApiCode.MODULE_NOT_FOUND));

        Action action = actionRepository.findByName(request.getActionName())
                .orElseThrow(() -> new BaseException(ApiCode.ACTION_NOT_FOUND));

        if (permissionRepository.findByKeyName(request.getKeyName()).isPresent()) {
            throw new BaseException(ApiCode.PERMISSION_EXISTS);
        }

        Permission permission = Permission.builder()
                .redModule(redModule)
                .action(action)
                .keyName(request.getKeyName())
                .name(request.getName())
                .description(request.getDescription())
                .build();

        permissionRepository.save(permission);
    }
}