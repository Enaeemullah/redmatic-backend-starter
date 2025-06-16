package com.redmatic.autotab.auth.controller;

import com.redmatic.autotab.auth.dto.RedModuleRequest;
import com.redmatic.autotab.auth.service.RedModuleService;
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
public class RedModuleController {

    private final RedModuleService moduleService;

    @PostMapping("/modules")
    public ResponseEntity<String> createModule(@RequestBody @Valid RedModuleRequest request) {
        moduleService.createModule(request);
        return ResponseEntity.ok("Module created successfully");
    }
}
