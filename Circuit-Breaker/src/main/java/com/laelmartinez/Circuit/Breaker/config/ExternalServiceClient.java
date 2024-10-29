package com.laelmartinez.Circuit.Breaker.config;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "externalService", url = "https://jsonplaceholder.typicode.com")
public interface ExternalServiceClient {

    @GetMapping("/posts/1")
    String getPost();
}
