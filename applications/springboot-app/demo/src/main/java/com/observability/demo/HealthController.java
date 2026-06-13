package com.observability.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping("/health")
    public String health() {
        return "Application Running";
    }

    @GetMapping("/version")
    public String version() {
        return "Version 1.0";
    }

    @GetMapping("/info")
    public String info() {
        return "Observability Lab Application";
    }
}
