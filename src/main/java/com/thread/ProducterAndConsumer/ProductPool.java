package com.thread.ProducterAndConsumer;

import java.util.LinkedList;
import java.util.List;

/**
 * 产品池
 * Created by hgg on 2019/9/29.
 */
public class ProductPool {

    //产品集合，生产者生产，消费者消费
    private List<Product> productList;

    private int MAX_SIZE = 0;

    public ProductPool(int maxSize){
        this.productList = new LinkedList<Product>();
        this.MAX_SIZE = maxSize;
    }

    /**
     * 生产—放入产品池
     * @param product
     */
    public synchronized void push(Product product)  {
        if (productList.size() == MAX_SIZE){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else {
            productList.add(product);
            this.notifyAll();
        }
    }

    /**
     * 每次取出第一个元素
     * @return
     */
    public synchronized Product pop() {
        Product product = null;
        if (this.productList.size() == 0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        product = productList.remove(0);
        this.notifyAll();
        return product;
    }
}
