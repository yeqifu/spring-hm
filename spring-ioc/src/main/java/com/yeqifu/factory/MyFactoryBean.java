package com.yeqifu.factory;

import com.yeqifu.dao.UserDao;
import com.yeqifu.dao.impl.UserDaoImpl;

/**
 * @author: yeqifu
 * @date: 2023/3/10 22:41
 */
public class MyFactoryBean {

    /**
     * 获得userDao
     *
     * @return
     */
    public static UserDao getUserDao(String name) {
        // 在返回userDaoImpl直接可以做一些前置操作
        System.out.println(name);
        return new UserDaoImpl();
    }
}
