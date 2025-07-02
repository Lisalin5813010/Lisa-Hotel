package com.example.roomwebapp.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/protected")
public class ProtectedController {

    @GetMapping("/resource")
    public ResponseEntity<String> getProtectedResource() {
        return ResponseEntity.ok("Congrats! This is a protected resource!");
    }
}
