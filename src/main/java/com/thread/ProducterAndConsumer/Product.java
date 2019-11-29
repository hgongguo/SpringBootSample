package com.thread.ProducterAndConsumer;

/**
 * 产品
 * Created by hgg on 2019/9/29.
 */
public class Product {
    private String name;

    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
