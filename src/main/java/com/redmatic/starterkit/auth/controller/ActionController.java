package com.redmatic.starterkit.auth.controller;

import com.redmatic.starterkit.auth.dto.ActionRequest;
import com.redmatic.starterkit.auth.service.ActionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ActionController {

    private final ActionService actionService;

    @PostMapping("/actions")
    public ResponseEntity<String> createAction(@RequestBody @Valid ActionRequest request) {
        actionService.createAction(request);
        return ResponseEntity.ok("Action created successfully");
    }
}
