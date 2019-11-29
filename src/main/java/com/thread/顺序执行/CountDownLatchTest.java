package com.thread.顺序执行;

import java.util.concurrent.CountDownLatch;

/**
 * Created by hgg on 2019/11/29.
 */
public class CountDownLatchTest {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);

        Employee_CDL a = new Employee_CDL("A",3000,countDownLatch);
        Employee_CDL b = new Employee_CDL("B",3000,countDownLatch);
        Employee_CDL c = new Employee_CDL("C",3000,countDownLatch);


        b.start();
        c.start();
        countDownLatch.await();

        System.out.println("BCOK");
        a.start();
    }



}
