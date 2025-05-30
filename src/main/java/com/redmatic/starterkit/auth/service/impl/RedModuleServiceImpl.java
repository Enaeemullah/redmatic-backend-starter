package com.redmatic.starterkit.auth.service.impl;

import com.redmatic.starterkit.auth.dto.RedModuleRequest;
import com.redmatic.starterkit.auth.entity.RedModule;
import com.redmatic.starterkit.auth.repository.RedModuleRepository;
import com.redmatic.starterkit.auth.service.RedModuleService;
import com.redmatic.starterkit.constants.ApiCode;
import com.redmatic.starterkit.core.exception.BaseException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RedModuleServiceImpl implements RedModuleService {

    private final RedModuleRepository moduleRepository;

    @Override
    public void createModule(RedModuleRequest request) {
        if (moduleRepository.findByName(request.getName()).isPresent()) {
            throw new BaseException(ApiCode.MODULE_EXISTS);
        }

        RedModule module = RedModule.builder()
                .name(request.getName())
                .description(request.getDescription())
                .build();
        moduleRepository.save(module);
    }
}
