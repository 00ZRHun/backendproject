package com.sabs.backendproject.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "testing")
public class TestController {
    
    @GetMapping
    @ResponseBody
    public ResponseEntity<String> getServerStatus() {
        return ResponseEntity.ok("Server is up and running");
    }
    
}
