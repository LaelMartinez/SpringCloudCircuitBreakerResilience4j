package com.laelmartinez.Circuit.Breaker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.laelmartinez.Circuit.Breaker.services.ExampleService;

@RestController
@RequestMapping("/api")
public class ExampleController {

    private final ExampleService exampleService;

    public ExampleController(ExampleService exampleService) {
        this.exampleService = exampleService;
    }

    @GetMapping("/data")
    public String getData() {
        return exampleService.getDataFromExternalService();
    }
}
