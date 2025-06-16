package com.redmatic.autotab.core.controller;

import com.redmatic.autotab.constants.ApiURI;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiURI.API_BASE_PATH)
public class HealthCheckController {

    @GetMapping("/health")
    public ResponseEntity<String> ping() {
        return ResponseEntity.ok("Backend server is running 🚀");
    }
}
