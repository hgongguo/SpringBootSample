package com.thread.ProducterAndConsumer;

/**
 * 生产者
 * Created by hgg on 2019/9/29.
 */
public class Producter extends Thread {

    private ProductPool pool;

    public Producter(ProductPool pool) {
        this.pool = pool;
    }

    @Override
    public void run() {
        while (true){
            String name = (int)Math.random()*100+"号";
            System.out.println("生产了"+name);
            Product product = new Product(name);
            this.pool.push(product);
        }
    }
}
