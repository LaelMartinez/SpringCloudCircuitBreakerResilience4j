package com.laelmartinez.Circuit.Breaker.gateway;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "externalService2", url = "https://viacep.com.br/ws/")
public interface ExternalServiceClient2 {

    @GetMapping("/08440180/json/")
    String getPost();
}
