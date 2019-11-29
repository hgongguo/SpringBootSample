package com.thread2;

/**
 * Created by hgg on 2019/10/1.
 * stackSize
 */
public class StackOverflowTest2 {

    public static int counter = 0;
    public static void main(String[] args) {

        /*Thread t0 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    add(0);
                }catch (Error e){
                    e.printStackTrace();
                    System.out.println(counter);
                }
            }
            private void add(int index){
                ++counter;
                add(index + 1);
            }
        });

        t0.start();*/

        Thread t1 = new Thread(null, new Runnable() {
            @Override
            public void run() {
                try {
                    add(0);
                }catch (Error e){
                    e.printStackTrace();
                    System.out.println(counter);
                }
            }
            private void add(int index){
                ++counter;
                add(index + 1);
            }
        },"atest",1<<24);

        t1.start();

    }

}
