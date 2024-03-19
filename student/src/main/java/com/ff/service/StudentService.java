package com.ff.service;

import com.ff.domain.Student;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author iloveit
* @description 针对表【student】的数据库操作Service
* @createDate 2024-03-15 15:36:59
*/
public interface StudentService extends IService<Student> {

    List<Student> listAll();


    List<Student> echoStudent(String id);
}
