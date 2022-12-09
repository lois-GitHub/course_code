package com.web_work.service;

import com.web_work.mapper.UserMapper;
import com.web_work.pojo.User;
import com.web_work.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;



public class UserService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    public boolean selectAll(String username, String password){
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectAll(username, password);
        System.out.println(user);
        return user!=null;
    }
}
