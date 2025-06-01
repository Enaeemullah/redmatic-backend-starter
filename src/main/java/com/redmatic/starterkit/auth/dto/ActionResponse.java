package com.redmatic.starterkit.auth.dto;

import com.redmatic.starterkit.constants.ActionType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ActionResponse {
    private Long id;
    private String name;
    private ActionType type;
    private String moduleName;
    private Long moduleId;
}
