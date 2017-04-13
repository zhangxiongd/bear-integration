package com.bear.server;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zhangxiong
 * @date 2017/4/13.
 */
public class BootStrap {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "provider.xml" });
        context.start();
        System.in.read();
    }
}
