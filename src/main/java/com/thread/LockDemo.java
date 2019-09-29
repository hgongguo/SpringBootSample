package com.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock
 * Created by hgg on 2019/9/24.
 */
public class LockDemo {
    public static void main(String[] args) {

        ReentrantLock lock = new ReentrantLock();
        Runnable r = () ->{
            while (TicketCenter.restCount > 0){
                lock.lock();
                System.out.println(Thread.currentThread().getName() + "|余票：" + (--TicketCenter.restCount));
                lock.unlock();
            }
        };
        Thread t1 = new Thread(r,"thread - 1");
        Thread t2 = new Thread(r,"thread - 2");
        Thread t3 = new Thread(r,"thread - 3");
        Thread t4 = new Thread(r,"thread - 4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }
}
