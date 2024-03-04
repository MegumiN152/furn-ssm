package com.hh.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 黄昊
 * @version 1.0
 **/
public class ConfigTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println(ioc.getBean("pooldataSource"));
        System.out.println(ioc.getBean("sqlSessionFactory"));
    }

}
