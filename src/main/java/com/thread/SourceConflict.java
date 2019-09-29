package com.thread;

/**
 * 临界资源
 * Created by hgg on 2019/9/24.
 */
public class SourceConflict {
    public static void main(String[] args) {
        Runnable r = () ->{
            while (TicketCenter.restCount > 0){
                System.out.println(Thread.currentThread().getName()+"|余票："+(--TicketCenter.restCount));
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

class TicketCenter{
    public static int restCount = 100;
}
