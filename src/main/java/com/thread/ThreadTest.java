package com.thread;

/**
 * Created by hgg on 2019/9/20.
 * Thread测试玩耍
 */
public class ThreadTest {
    public static void main(String[] args) {

        //1、Thread
        for (int i=0;i<2;i++){
            MyThread myThread = new MyThread();
            myThread.start();
        }
        System.out.println("主结束");

        //2、runnable
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<10;i++){
                    System.out.println("runnabe---1："+i);
                }
            }
        };


        Thread th1 = new Thread(runnable);
        th1.start();

        Runnable r1 = () -> {
            for (int i=0;i<10;i++){
                System.out.println("runnabel2："+i);
            }
        };

        Thread th = new Thread(r1);
        th.start();

    }
}

class MyThread extends Thread{
    @Override
    public void run() {
        for (int i=0;i<10;i++){
            System.out.println(Thread.currentThread().getName()+"子i："+i);
        }
    }
}
