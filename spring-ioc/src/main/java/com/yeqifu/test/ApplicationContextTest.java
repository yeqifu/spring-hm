package com.yeqifu.test;

import com.yeqifu.dao.UserDao;
import com.yeqifu.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: yeqifu
 * @date: 2023/3/5 20:48
 */
public class ApplicationContextTest {
    public static void main(String[] args) {
        /*ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) applicationContext.getBean("userService");
        UserService userService2 = (UserService) applicationContext.getBean("userService");
        System.out.println(userService);
        System.out.println(userService2);
        // 显示的关闭容器，才会调用destroyMethod方法
        applicationContext.close();*/


        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao2 = (UserDao) applicationContext.getBean("userDao2");
        System.out.println(userDao2);
    }
}
