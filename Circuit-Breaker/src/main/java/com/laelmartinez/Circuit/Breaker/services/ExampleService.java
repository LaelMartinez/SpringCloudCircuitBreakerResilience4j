package com.laelmartinez.Circuit.Breaker.services;

import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;

import com.laelmartinez.Circuit.Breaker.config.ExternalServiceClient;

@Service
public class ExampleService {

    @SuppressWarnings("rawtypes")
	private final CircuitBreakerFactory circuitBreakerFactory;
    private final ExternalServiceClient externalServiceClient;

    public ExampleService(@SuppressWarnings("rawtypes") CircuitBreakerFactory circuitBreakerFactory, ExternalServiceClient externalServiceClient) {
        this.circuitBreakerFactory = circuitBreakerFactory;
        this.externalServiceClient = externalServiceClient;
    }

    public String getDataFromExternalService() {
        return circuitBreakerFactory.create("exampleService")
            .run(externalServiceClient::getPost, throwable -> fallbackMethod());
    }

    private String fallbackMethod() {
        return "Dados de Fallback";
    }
}
