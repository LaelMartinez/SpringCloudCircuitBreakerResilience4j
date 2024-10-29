package com.laelmartinez.Circuit.Breaker.gateway;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "externalService", url = "http://localhost:8080")
public interface ExternalServiceClient {

    @GetMapping("/howtos")
    String getPost();
}
