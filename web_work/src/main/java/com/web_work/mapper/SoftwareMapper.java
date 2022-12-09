package com.web_work.mapper;

import com.web_work.pojo.SoftWare;
import org.apache.ibatis.annotations.*;

import java.util.List;


public interface SoftwareMapper {
    //查询所有
    @Select("select * from web_dazuoye.software")
    public List<SoftWare> selectAll();

    //通过名字查询
    @Select("select * from web_dazuoye.software where name=#{name}")
    public SoftWare selectByName(@Param("name") String name);

    //通过id查询
    @Select("select * from web_dazuoye.software where id=#{id}")
    public SoftWare selectById(@Param("id") int id);

    //添加软件
    @Insert("insert into web_dazuoye.software(name, depart, description, score) values (#{name}, #{depart}, #{description},#{score})")
    public void add(@Param("name") String name, @Param("depart") String depart, @Param("description") String description, @Param("score") String score);


    //删除软件
    @Delete("delete from web_dazuoye.software where id=#{id}")
    public void delete(@Param("id") int id);

}
