package com.ad.admin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/test")
public class TestController {

    @GetMapping("/info")
    public Map<String, Object> testInfoGET() {
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("data", "ad admin back");
        resultMap.put("result", "success");
        return resultMap;
    }
}
