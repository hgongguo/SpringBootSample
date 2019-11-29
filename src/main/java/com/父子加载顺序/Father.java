package com.父子加载顺序;

public class Father extends FatherFather {
    public String fStr1 = "father1";
    protected String fStr2 = "father2";
    private String fStr3 = "father3";
 
    {
        System.out.println("Father common block be called");
    }
 
    static {
        System.out.println("Father static block be called");
    }
 
    public Father() {
        System.out.println("Father constructor be called");
    }
 
}