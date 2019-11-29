package com.thread.ProducterAndConsumer;

/**
 * Created by hgg on 2019/9/29.
 */
public class MainProgram {
    public static void main(String[] args) {
        ProductPool productPool = new ProductPool(15);

        new Producter(productPool).start();

        new Consumer(productPool).start();
    }
}
