package com.voronina.gb.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RecordGateway {

    public static void main(String[] args) {
        SpringApplication.run(RecordGateway.class, args);
    }

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("Microservice1",r->r.path("/records/**")
                        .uri("http://localhost:8080/"))
                .route("Microservice2",r->r.path("/users/**")
                        .uri("http://localhost:8800/")).build();
    }
}
