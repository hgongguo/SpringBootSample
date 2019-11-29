package com.thread.顺序执行;

/**
 * Created by hgg on 2019/11/29.
 */
public class JoinTest {
    public static void main(String[] args) throws InterruptedException {
        Employee e1 = new Employee("A",3000);
        Employee e2 = new Employee("B",3000);
        Employee e3 = new Employee("C",3000);

        e2.start();
        e3.start();

        e2.join();
        e3.join();

        System.out.println("BCOK");

        e1.start();
    }
}
