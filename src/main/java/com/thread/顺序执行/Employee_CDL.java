package com.thread.顺序执行;

import java.util.concurrent.CountDownLatch;

public class Employee_CDL extends Thread{

    private String employeeName;

    private long time;
    private CountDownLatch countDownLatch;

    public Employee_CDL(String employeeName, long time, CountDownLatch countDownLatch){
        this.employeeName = employeeName;
        this.time = time;
        this.countDownLatch = countDownLatch;
    }
    
    @Override
    public void run() {
        try {
            System.out.println(employeeName+ "一阶段准备");
            Thread.sleep(time);
            System.out.println(employeeName+" 一阶段完成");
            countDownLatch.countDown();

            System.out.println(employeeName+ "②开始准备");
            Thread.sleep(time);
            System.out.println(employeeName+" ②准备完成");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}