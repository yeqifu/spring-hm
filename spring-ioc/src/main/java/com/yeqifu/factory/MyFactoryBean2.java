package com.yeqifu.factory;

import com.yeqifu.dao.UserDao;
import com.yeqifu.dao.impl.UserDaoImpl;

/**
 * 获取userDaoImpl的工厂类
 *
 * @author: yeqifu
 * @date: 2023/3/12 11:00
 */
public class MyFactoryBean2 {
    /**
     * 非静态工厂方法
     *
     * @return
     */
    public UserDao getUserDao(String name) {
        // 在这里可以做一些获取bean的前置操作
        System.out.println(name);
        return new UserDaoImpl();
    }
}
