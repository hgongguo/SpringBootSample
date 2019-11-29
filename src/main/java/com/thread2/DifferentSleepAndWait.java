package com.thread2;

import java.util.stream.Stream;

/**
 * Created by hgg on 2019/10/3.
 */
public class DifferentSleepAndWait {

    public static void main(String[] args) {
//        m1();
//        m2();

        Stream.of("T1","T2").forEach(name ->
                new Thread(name){
                    @Override
                    public void run() {
                        m2();
                    }
                }.start()
        );
    }

    public static void m1()  {
        synchronized(LOCK){
            try {
                System.out.println(Thread.currentThread().getName()+"||enter");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    private static Object LOCK  = new Object();

    public static void m2()  {
        synchronized (LOCK){
            try {
                System.out.println(Thread.currentThread().getName()+"||enter");
                LOCK.wait(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
