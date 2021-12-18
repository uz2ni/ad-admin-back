package com.spring.tester.modules.main.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("/api/v1/main")
    public String getRoot() {
        return "mainTest";
    }

    @PostMapping("/api/v1/main")
    public String setAuth() {
        return "setAuth";
    }
}
