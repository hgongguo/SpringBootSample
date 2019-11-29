package com.父子加载顺序;

public class FatherFather {
    public String fStr1 = "father1";
    protected String fStr2 = "father2";
    private String fStr3 = "father3";

    {
        System.out.println("Top Father common block be called");
    }

    static {
        System.out.println("Top Father static block be called");
    }

    public FatherFather() {
        System.out.println("Top Father constructor be called");
    }
 
}