package com.yeqifu.service.impl;

import com.yeqifu.dao.UserDao;
import com.yeqifu.dao.impl.UserDaoImpl;
import com.yeqifu.service.UserService;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author: yeqifu
 * @date: 2023/3/5 18:32
 */
public class UserServiceImpl implements UserService, InitializingBean {

    private UserDao userDao;

    public UserServiceImpl() {
        System.out.println("UserServiceImpl创建了，调用了无参构造方法...");
    }

    public UserServiceImpl(String nickName, Integer age) {
        System.out.println("UserServiceImpl创建了，调用了有参构造方法...  --->  nickName = " + nickName + "   age = " + age);
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    /**
     * bean的初始化方法
     */
    private void initMethod() {
        System.out.println("执行初始化方法：该方法在bean被实例化之后执行");
    }

    /**
     * bean的销毁方法
     */
    private void destroyMethod() {
        System.out.println("执行销毁方法：该方法在bean被销毁之前执行");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("initializingBean的afterPropertiesSet方法执行的时机早于init-method方法...");
    }
}
