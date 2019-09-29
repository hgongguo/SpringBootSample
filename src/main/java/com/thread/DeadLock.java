package com.thread;

/**
 * Created by hgg on 2019/9/24.
 */
public class DeadLock {

    public static void main(String[] args) {
        Runnable r1 = () ->{
            synchronized ("A"){
                System.out.println("|持有A锁，等待B");
                synchronized ("B"){
                    System.out.println("|线程同时持有A、B");
                }
            }
        };
        Runnable r2 = () ->{
            synchronized ("B"){
                System.out.println("||持有B锁，等待A");
                synchronized ("A"){
                    System.out.println("||线程同时持有A、B");
                }
            }
        };

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        t1.start();
        t2.start();
    }
}
