package com.cl.test.mybatis;

import com.cl.test.model.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<Student> getById(int id);
}
