package com.redmatic.starterkit.auth.service;

import com.redmatic.starterkit.auth.dto.ActionRequest;
import com.redmatic.starterkit.auth.dto.ActionResponse;

import java.util.List;

public interface ActionService {
    void createAction(ActionRequest request);
    List<ActionResponse> getAllActions();
}
