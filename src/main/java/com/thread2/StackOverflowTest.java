package com.thread2;

/**
 * Created by hgg on 2019/10/1.
 * 压栈
 */
public class StackOverflowTest {

    public static int counter = 0;
    public static void main(String[] args) {
        try {
            add(0);
        }catch (Error e){
            e.printStackTrace();
            System.out.println(counter);
        }
    }

    private static void add(int index){
        ++counter;
        add(index + 1);
    }
}
