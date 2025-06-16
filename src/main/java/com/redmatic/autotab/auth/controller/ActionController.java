package com.redmatic.autotab.auth.controller;

import com.redmatic.autotab.auth.dto.ActionRequest;
import com.redmatic.autotab.auth.dto.ActionResponse;
import com.redmatic.autotab.auth.service.ActionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ActionController {

    private final ActionService actionService;

    @PostMapping("/actions")
    public ResponseEntity<String> createAction(@RequestBody @Valid ActionRequest request) {
        actionService.createAction(request);
        return ResponseEntity.ok("Action created successfully");
    }

    @GetMapping("/actions")
    public ResponseEntity<List<ActionResponse>> getAllActions() {
        return ResponseEntity.ok(actionService.getAllActions());
    }
}
