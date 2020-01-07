package com.der.webfluxstart.configuration;

import com.der.webfluxstart.entity.Good;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_STREAM_JSON;
import static org.springframework.http.MediaType.TEXT_PLAIN;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

/**
 * @program: webflux-start
 * @description: ${description}
 * @author: long
 * @create: 2020-01-07 11:15
 */
@Component
@Configuration
public class GoodHandler {

    private final Flux<Good> goods;

    public GoodHandler(GoodGenerator goodGenerator) {
        this.goods = goodGenerator.findGoods();
    }

    public Mono<ServerResponse> hello(ServerRequest request) {
        return ok().contentType(TEXT_PLAIN)
                .body(BodyInserters.fromObject("Hello Spring!"));
    }

    public Mono<ServerResponse> echo(ServerRequest request) {
        return ok().contentType(APPLICATION_STREAM_JSON).body(this.goods,Good.class);
    }
}
