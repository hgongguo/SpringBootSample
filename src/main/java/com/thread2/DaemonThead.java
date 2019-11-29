package com.thread2;

/**
 * Created by hgg on 2019/10/1.
 * 守护线程
 */
public class DaemonThead {
    public static void main(String[] args) {
        Thread t1 = new Thread(){
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName()+"running");
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
