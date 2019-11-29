package com.thread2;

/**
 * Created by hgg on 2019/10/1.
 * 守护线程--1、长连接，2、主线程消亡，子线程跟着dead
 */
public class DaemonThead2 {
    public static void main(String[] args) {
        Thread t1 = new Thread(){
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName()+"running");

                    Thread innerThread = new Thread(()->{
                        while (true){
                            System.out.println("do sth>>>>.....");
                            try {
                                sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    });
//                    innerThread.setDaemon(true);
                    innerThread.start();

                    Thread.sleep(5_000);
                    System.out.println(Thread.currentThread().getName()+"dead");


                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };

        t1.setDaemon(true);
        //runnable->running || dead -> blocked
        t1.start();


        try {
            Thread.sleep(1_000);
            System.out.println(Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
