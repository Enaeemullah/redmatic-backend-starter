package com.redmatic.autotab.auth.service;

import com.redmatic.autotab.auth.dto.ActionRequest;
import com.redmatic.autotab.auth.dto.ActionResponse;

import java.util.List;

public interface ActionService {
    void createAction(ActionRequest request);
    List<ActionResponse> getAllActions();
}
