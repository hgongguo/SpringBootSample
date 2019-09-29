package com.thread;

/**
 * Created by hgg on 2019/9/24.
 */
public class ThreadSingleTon {

    public static void main(String[] args) {

        Runnable runnable = () ->{
            Boss.getBoss();
//            System.out.println(Thread.currentThread().getName());
        };
        for (int i = 0; i< 100; i++){
            new Thread(runnable,"T"+i).start();
        }
    }
}

class Boss{
    private Boss(){
        System.out.println("BOss出来了");
    }

    private static Boss instance = null;

    public static Boss getBoss(){
        synchronized (""){
            if (instance == null){
                instance = new Boss();
            }
        }
        return instance;
    }
}
