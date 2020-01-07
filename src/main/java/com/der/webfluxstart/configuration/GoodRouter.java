package com.der.webfluxstart.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 * @program: webflux-start
 * @description: ${description}
 * @author: long
 * @create: 2020-01-07 13:31
 */
@Configuration
public class GoodRouter {

    @Bean
    public RouterFunction<ServerResponse> route(GoodHandler goodHandler) {
        return RouterFunctions
            .route(RequestPredicates.GET("/good")
                    .and(RequestPredicates.accept(MediaType.TEXT_PLAIN)),goodHandler::hello)
            .andRoute(RequestPredicates.GET("/goods")
                    .and(RequestPredicates.accept(MediaType.APPLICATION_STREAM_JSON)),goodHandler::echo);
    }
}
