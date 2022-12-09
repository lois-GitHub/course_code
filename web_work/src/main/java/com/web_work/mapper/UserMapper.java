package com.web_work.mapper;

import com.web_work.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


public interface UserMapper {
    //查询所有
    @Select("select * from web_dazuoye.user where username=#{username} and password=#{password}")
    public User selectAll(@Param("username")String username, @Param("password")String password);

//    @Select("select * from web_dazuoye.user")
//    public List<User> selectAll();
}
