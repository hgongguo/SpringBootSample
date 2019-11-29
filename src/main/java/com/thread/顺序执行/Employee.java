package com.thread.顺序执行;

public class Employee extends Thread{
        
    private String employeeName;
    
    private long time;

    public Employee(String employeeName,long time){
        this.employeeName = employeeName;
        this.time = time;
    }
    
    @Override
    public void run() {
        try {
            System.out.println(employeeName+ "开始准备");
            Thread.sleep(time);
            System.out.println(employeeName+" 准备完成");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}