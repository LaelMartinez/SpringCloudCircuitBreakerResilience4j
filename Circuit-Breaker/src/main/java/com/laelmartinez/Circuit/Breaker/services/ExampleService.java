package com.laelmartinez.Circuit.Breaker.services;

import com.laelmartinez.Circuit.Breaker.gateway.ExternalServiceClient;
import com.laelmartinez.Circuit.Breaker.gateway.ExternalServiceClient2;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;

@Service
public class ExampleService {

    @SuppressWarnings("rawtypes")
	private final CircuitBreakerFactory circuitBreakerFactory;
    private final ExternalServiceClient externalServiceClient;
    private final ExternalServiceClient2 externalServiceClient2;

    public ExampleService(@SuppressWarnings("rawtypes") CircuitBreakerFactory circuitBreakerFactory, ExternalServiceClient externalServiceClient, ExternalServiceClient2 externalServiceClient2) {
        this.circuitBreakerFactory = circuitBreakerFactory;
        this.externalServiceClient = externalServiceClient;
        this.externalServiceClient2 = externalServiceClient2;
    }

    public String getDataFromExternalService() {
        return circuitBreakerFactory.create("exampleService")
            .run(externalServiceClient::getPost, throwable -> getDataFromExternalService2());
    }

    public String getDataFromExternalService2() {
        return circuitBreakerFactory.create("exampleService2")
                .run(externalServiceClient2::getPost, throwable -> fallbackMethod());
    }

    private String fallbackMethod() {

        return "Dados de Fallback";
    }
}
