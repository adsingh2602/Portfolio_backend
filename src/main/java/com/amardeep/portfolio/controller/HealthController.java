package com.amardeep.portfolio.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping("/api/public/health")
    public String health() {
        return "OK - Portfolio backend is running";
    }
}
