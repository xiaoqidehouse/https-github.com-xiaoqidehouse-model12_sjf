package com.ff.mapper;

import com.ff.domain.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author iloveit
* @description 针对表【student】的数据库操作Mapper
* @createDate 2024-03-15 15:36:59
* @Entity com.ff.domain.Student
*/
public interface StudentMapper extends BaseMapper<Student> {

    List<Student> listAll();


    List<Student> echoStudent(String id);
}




