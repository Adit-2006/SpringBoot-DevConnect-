package com.example.Starter.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController 
public class HealthController {
    @GetMapping("/helath")
    public String getHealth(){
        return "DevConnect Application is live.";
    }
    @GetMapping("/api/v1/status")
    public Map<String, Object> getStatus(){
        return null;
    }
    
}