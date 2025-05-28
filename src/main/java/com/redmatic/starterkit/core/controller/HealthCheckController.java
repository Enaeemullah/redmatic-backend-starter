package com.redmatic.starterkit.core.controller;

import com.redmatic.starterkit.constants.AppConstants;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(AppConstants.API_BASE_PATH)
public class HealthCheckController {

    @GetMapping("/health")
    public ResponseEntity<String> ping() {
        return ResponseEntity.ok("Backend server is running 🚀");
    }
}
