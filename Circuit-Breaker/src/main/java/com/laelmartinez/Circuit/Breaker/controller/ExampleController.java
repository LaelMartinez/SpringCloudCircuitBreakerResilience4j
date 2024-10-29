package com.laelmartinez.Circuit.Breaker.controller;

import com.laelmartinez.Circuit.Breaker.services.ExampleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ExampleController {

    private final ExampleService exampleService;


    public ExampleController(ExampleService exampleService) {

        this.exampleService = exampleService;
    }

    @GetMapping
    public String getAPI(){
         return "Helo from /API";
    }

    @GetMapping("/data")
    public String getData() {
        return exampleService.getDataFromExternalService();
    }
}
