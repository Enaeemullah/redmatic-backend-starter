package com.redmatic.starterkit.auth.service.impl;

import com.redmatic.starterkit.auth.dto.PermissionRequest;
import com.redmatic.starterkit.auth.entity.Action;
import com.redmatic.starterkit.auth.entity.Permission;
import com.redmatic.starterkit.auth.entity.RedModule;
import com.redmatic.starterkit.auth.repository.ActionRepository;
import com.redmatic.starterkit.auth.repository.PermissionRepository;
import com.redmatic.starterkit.auth.repository.RedModuleRepository;
import com.redmatic.starterkit.auth.service.PermissionService;
import com.redmatic.starterkit.constants.ApiCode;
import com.redmatic.starterkit.core.exception.BaseException;
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