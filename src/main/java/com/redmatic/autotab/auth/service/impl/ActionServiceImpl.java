package com.redmatic.autotab.auth.service.impl;

import com.redmatic.autotab.auth.dto.ActionRequest;
import com.redmatic.autotab.auth.dto.ActionResponse;
import com.redmatic.autotab.auth.entity.Action;
import com.redmatic.autotab.auth.repository.ActionRepository;
import com.redmatic.autotab.auth.service.ActionService;
import com.redmatic.autotab.constants.ApiCode;
import com.redmatic.autotab.core.exception.BaseException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ActionServiceImpl implements ActionService {

    private final ActionRepository actionRepository;

    @Override
    public void createAction(ActionRequest request) {
        if (actionRepository.findByName(request.getName()).isPresent()) {
            throw new BaseException(ApiCode.ACTION_EXISTS);
        }

        Action action = Action.builder()
                .name(request.getName())
                .module(request.getModule())
                .description(request.getDescription())
                .createPermission(request.isCreate())
                .readPermission(request.isRead())
                .updatePermission(request.isUpdate())
                .deletePermission(request.isDelete())
                .build();

        actionRepository.save(action);
    }

    @Override
    public List<ActionResponse> getAllActions() {
        return actionRepository.findAll().stream()
                .map(action -> ActionResponse.builder()
                        .id(action.getId())
                        .name(action.getName())
                        .build())
                .toList();
    }

}
