package com.thread2;

/**
 * Created by hgg on 2019/9/29.
 */
public class TryConcurrency {
    public static void main(String[] args) {
        Thread t1 = new Thread("hgg Thread test"){
            @Override
            public void run() {
                for (int i = 0; i<1000;i++){
                    System.out.println(i);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t1.start();


        Thread t2 = new Thread();
        Thread t3 = new Thread();


        t2.start();
        t3.start();
        System.out.println(t2.getName()+"||"+t3.getName());
    }
}
