package com.redmatic.autotab.auth.service.impl;

import com.redmatic.autotab.auth.dto.RedModuleRequest;
import com.redmatic.autotab.auth.entity.RedModule;
import com.redmatic.autotab.auth.repository.RedModuleRepository;
import com.redmatic.autotab.auth.service.RedModuleService;
import com.redmatic.autotab.constants.ApiCode;
import com.redmatic.autotab.core.exception.BaseException;
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
                .build();
        moduleRepository.save(module);
    }
}
