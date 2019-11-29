package com.thread;


public class synchronizedTestDemo {
    public static void main(String[] args) {
        /*Runnable r = () ->{
            while (TicketCenter.restCount > 0){
                synchronized (""){
                    if (TicketCenter.restCount <= 0){
                        return;
                    }
                    System.out.println(Thread.currentThread().getName()+"|余票："+(--TicketCenter.restCount));
                }
            }
        };
        Thread t1 = new Thread(r,"thread - 1");
        Thread t2 = new Thread(r,"thread - 2");
        Thread t3 = new Thread(r,"thread - 3");
        Thread t4 = new Thread(r,"thread - 4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();*/

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                testFunc();
            }
        };
        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                testFunc2();
            }
        };
        /*for (int j = 1;j<1000;j++){
            new Thread(runnable,"t"+j).start();
        }*/


        for (int j = 1;j<1000;j++){
            new Thread(runnable2,"t"+j).start();
        }


    }

    private static int i = 1;

    public static void testFunc(){
        System.out.println("first"+Thread.currentThread().getName()+"："+i++);
    }
    public static synchronized void testFunc2(){
        System.out.println("Second"+Thread.currentThread().getName()+"："+i++);
    }
}
