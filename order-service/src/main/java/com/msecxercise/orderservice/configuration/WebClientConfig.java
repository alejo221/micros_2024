package com.msecxercise.orderservice.configuration;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;


@Configuration
public class WebClientConfig {
    @Bean
    @LoadBalanced
    // En caso de tener mas de una instancia a consumir del mismo micro, esta anotación balancea las peticiones y se enfocará en las activas sin generar excepciones
    public WebClient.Builder webClientBuilder(){
        return WebClient.builder();
    }
}
