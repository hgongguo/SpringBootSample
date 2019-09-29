package com.thread;

/**
 * Created by hgg on 2019/9/24.
 */
public class synchronizedFunction {
    public static void main(String[] args) {
        Runnable r = () ->{
            while (TicketCenter.restCount > 0){
                soldTicket();
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

    public synchronized static void soldTicket(){
        if (TicketCenter.restCount <= 0){
            return;
        }
        System.out.println(Thread.currentThread().getName()+"|余票："+(--TicketCenter.restCount));
    }
}
