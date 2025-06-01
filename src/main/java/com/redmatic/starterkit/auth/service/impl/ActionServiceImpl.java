package com.redmatic.starterkit.auth.service.impl;

import com.redmatic.starterkit.auth.dto.ActionRequest;
import com.redmatic.starterkit.auth.dto.ActionResponse;
import com.redmatic.starterkit.auth.entity.Action;
import com.redmatic.starterkit.auth.repository.ActionRepository;
import com.redmatic.starterkit.auth.service.ActionService;
import com.redmatic.starterkit.constants.ApiCode;
import com.redmatic.starterkit.core.exception.BaseException;
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
