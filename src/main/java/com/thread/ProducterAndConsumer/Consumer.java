package com.thread.ProducterAndConsumer;

/**
 * 消费者
 * Created by hgg on 2019/9/29.
 */
public class Consumer extends Thread {
    private ProductPool pool;

    public Consumer(ProductPool pool) {
        this.pool = pool;
    }

    @Override
    public void run() {
        while (true){
            Product product = this.pool.pop();
            System.out.println("消费了："+product.getName());
        }
    }
}
