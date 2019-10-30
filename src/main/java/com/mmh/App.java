package com.mmh;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Hello world!
 *
 * 每个基于 MyBatis 的应用都是以一个 SqlSessionFactory 的实例为核心的。
 *
 * 2种方式配置数据库信息（xml\JAVA代码）
 *
 * 2种方式配置SQL语句（xml\注解）
 *
 * mybatis2个重要的配置文件：mybatis-config.xml,xxxMapper.xml
 *
 * 作用域和生命周期（SqlSessionFactoryBuilder\SqlSessionFactory\SqlSession\mapper）
 */
public class App{
    public static void main( String[] args ) throws IOException {
        //编程式调用mybatis（xml文件配置），还有一种代码式调用（java代码配置）
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = userMapper.getById(1L);
            System.out.println(user.getName());
        }finally {
            sqlSession.close();
        }
    }
}
