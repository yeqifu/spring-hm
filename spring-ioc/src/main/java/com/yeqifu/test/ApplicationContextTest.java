package com.yeqifu.test;

import com.yeqifu.dao.UserDao;
import com.yeqifu.dao.impl.UserDaoImpl;
import com.yeqifu.service.UserService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: yeqifu
 * @date: 2023/3/5 20:48
 */
public class ApplicationContextTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException, ParseException, IOException {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        /*UserService userService = (UserService) applicationContext.getBean("userService");
        UserService userService2 = (UserService) applicationContext.getBean("userService");
        System.out.println(userService);
        System.out.println(userService2);
        // 显示的关闭容器，才会调用destroyMethod方法
        applicationContext.close();*/

        UserDaoImpl userDao = applicationContext.getBean(UserDaoImpl.class);
        System.out.println(userDao);
        // 通过静态工厂方法获取bean
        /*UserDao userDao2 = (UserDao) applicationContext.getBean("userDao2");
        System.out.println(userDao2);*/

        // 获取 dataSource
        Object dataSource = applicationContext.getBean("dataSource");
        System.out.println(dataSource);

        // 传统方式获取 connection
        /*Class.forName("com.mysql.cj.jdbc.Driver");
        Connection oldConnection = DriverManager.getConnection("jdbc://localhost:3306/hmdp", "root", "123456");
        System.out.println(oldConnection);*/

        // 通过 spring xml 方式获取 connection
        /*Object springConnection = applicationContext.getBean("connection");
        System.out.println(springConnection);*/

        // 原始的 java 写法
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = simpleDateFormat.parse("2023-08-27 17:00:00");
        System.out.println(now);

        // 通过 spring xml 获取
        Object date = applicationContext.getBean("date");
        System.out.println(date);

        // java 代码的写法
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        System.out.println(sqlSession);

        // 通过 spring xml 获取
        SqlSessionFactory xmlSqlSessionFactory = (SqlSessionFactory)applicationContext.getBean("sqlSessionFactory");
        SqlSession xmlSqlSession = xmlSqlSessionFactory.openSession();
        System.out.println(xmlSqlSession);
    }
}
