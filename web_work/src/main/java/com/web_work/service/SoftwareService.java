package com.web_work.service;

import com.web_work.mapper.SoftwareMapper;
import com.web_work.mapper.UserMapper;
import com.web_work.pojo.SoftWare;
import com.web_work.pojo.User;
import com.web_work.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class SoftwareService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    public boolean selectAll(String username, String password) {
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectAll(username, password);
        sqlSession.commit();
        sqlSession.close();
        return user != null;
    }

    public List<SoftWare> selectAll() {
        SqlSession sqlSession = factory.openSession();
        SoftwareMapper mapper = sqlSession.getMapper(SoftwareMapper.class);
        List<SoftWare> softWares = mapper.selectAll();
        sqlSession.commit();
        sqlSession.close();
        return softWares;
    }

    public SoftWare selectByName(String name) {
        SqlSession sqlSession = factory.openSession();
        SoftwareMapper mapper = sqlSession.getMapper(SoftwareMapper.class);
        SoftWare softWare = mapper.selectByName(name);
        sqlSession.commit();
        sqlSession.close();
        return softWare;
    }

    public SoftWare selectById(int id) {
        SqlSession sqlSession = factory.openSession();
        SoftwareMapper mapper = sqlSession.getMapper(SoftwareMapper.class);
        SoftWare softWare = mapper.selectById(id);
        sqlSession.commit();
        sqlSession.close();
        return softWare;
    }

    public void add(String name, String depart, String description, String score) {
        SqlSession sqlSession = factory.openSession();
        SoftwareMapper mapper = sqlSession.getMapper(SoftwareMapper.class);
        mapper.add(name, depart, description, score);
        sqlSession.commit();
        sqlSession.close();
    }

    public void delete(int id) {
        SqlSession sqlSession = factory.openSession();
        SoftwareMapper mapper = sqlSession.getMapper(SoftwareMapper.class);
        mapper.delete(id);
        sqlSession.commit();
        sqlSession.close();
    }

}
