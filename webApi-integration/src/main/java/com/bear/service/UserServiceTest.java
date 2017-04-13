package com.bear.service;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zhangxiong
 * @date 2017/4/13.
 */
public class UserServiceTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] { "spring/consumer.xml" });

        context.start();

        UserService userService = (UserService) context.getBean("userService");
        String result = userService.getName("Nihao");

        System.out.println(result);
    }
}
