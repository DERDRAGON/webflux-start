package com.der.webfluxstart;

import com.alibaba.fastjson.JSON;
import com.der.webfluxstart.entity.Good;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class Spring5demoApplicationTests {

    @Resource
    private WebTestClient webTestClient;

    @Test
    public void contextLoads() {
        String s = webTestClient
                .get().uri("/good").accept(MediaType.TEXT_PLAIN).exchange()
                .expectStatus().isOk().returnResult(String.class)
                .getResponseBody().blockFirst();
        System.out.println(s);
    }

    @Test
    public void testFindGoods() {
        List<Good> list = webTestClient.get().uri("/goods").accept(MediaType.APPLICATION_STREAM_JSON).exchange()
                .expectStatus().isOk().expectHeader().contentType(MediaType.APPLICATION_STREAM_JSON)
                .returnResult(Good.class).getResponseBody().collectList().block();

        System.out.println(JSON.toJSONString(list));
    }

}
