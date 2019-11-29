package com.volatile_study;

public class VolatileTest2 {
    static class A {
        volatile int a = 0;
        void increase() {
            a++;
        }
        int getA(){
            return a;
        }
    }

    public static void main(String[] args) {
        A a = new A();

        new Thread(() -> {
            for (int i = 0;i < 1000;i++) {
                a.increase();
            }
            System.out.println(a.getA());
        }).start();
        new Thread(() -> {
            for (int i = 0;i < 2000;i++) {
                a.increase();
            }
            System.out.println(a.getA());
        }).start();
        new Thread(() -> {
            for (int i = 0;i < 3000;i++) {
                a.increase();
            }
            System.out.println(a.getA());
        }).start();
        new Thread(() -> {
            for (int i = 0;i < 4000;i++) {
                a.increase();
            }
            System.out.println(a.getA());
        }).start();
        new Thread(() -> {
            for (int i = 0;i < 5000;i++) {
                a.increase();
            }
            System.out.println(a.getA());
        }).start();
    }
}