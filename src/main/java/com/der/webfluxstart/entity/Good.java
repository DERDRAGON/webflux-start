package com.der.webfluxstart.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: webflux-start
 * @description: ${description}
 * @author: long
 * @create: 2020-01-07 10:18
 */
@Data
public class Good implements Serializable {

    private Integer id;

    private String name;

    private String from;

    private String to;

    public Good() {
    }

    public Good(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
