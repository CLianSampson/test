package com.cl.test.mybatis;

import com.cl.test.model.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

/**
 * @author sampson chen
 * @date 2021年12月26日 21:36
 *
 *  mybatis动态代理原理 https://segmentfault.com/a/1190000019130222
 *  spring事物为什么要使用  threadLocal   https://www.jianshu.com/p/c807740544c4
 *  springboot动态数据源   https://www.cnblogs.com/shihaiming/p/11067623.html   AbstractRoutingDataSource
 */
public class MybatisTest {

    public static void main(String[] args) throws IOException {
        //1. 读取mybatis-config.xml 文件
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

        //2. 构建SqlSessionFactory(创建了DefaultSqlSessionFactory)
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //3. 打开SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //4. 获取Mapper 接口对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //5. 获取mapper 接口对象的方法操作数据库
        //Arrays.asList(1L)
        List<Student> sysUsers = mapper.getById(1);
        System.out.println("查询结果为：" + sysUsers.size());

    }
}
