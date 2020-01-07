package com.der.webfluxstart.configuration;

import com.der.webfluxstart.entity.Good;
import com.google.common.collect.Lists;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;

import java.util.List;

/**
 * @program: webflux-start
 * @description: ${description}
 * @author: long
 * @create: 2020-01-07 11:07
 */
@Configuration
public class GoodGenerator {

    public Flux<Good> findGoods() {
        List<Good> goods = Lists.newArrayList(new Good(1, "香蕉"));
        goods.add(new Good(2, "苹果"));
        goods.add(new Good(3, "菠萝"));
        goods.add(new Good(4, "草莓"));
        return Flux.fromIterable(goods);
    }
}
