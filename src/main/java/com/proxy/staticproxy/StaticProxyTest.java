package com.proxy.staticproxy;

import com.proxy.Person;

/**
 * 静态代理测试
 * Created by hgg on 2019/11/17.
 * https://www.cnblogs.com/gonjan-blog/p/6685611.html
 */
public class StaticProxyTest {
    public static void main(String[] args) {
        Person zhangsan = new Student("张三");
        Person stuProxy = new StudentsProxy(zhangsan);
        stuProxy.giveMoney();
    }
}
