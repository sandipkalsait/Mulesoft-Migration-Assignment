package com.example.mule_migration.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {
    @GetMapping("/greet")
    public String getMessage()
    {
        String response="""
                    {
                    "message": "Hello from Spring Boot!"
                    }
                """;
        return response;
    }
}
