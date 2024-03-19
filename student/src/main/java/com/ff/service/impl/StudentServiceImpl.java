package com.ff.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ff.domain.Student;
import com.ff.service.StudentService;
import com.ff.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author iloveit
* @description 针对表【student】的数据库操作Service实现
* @createDate 2024-03-15 15:36:59
*/
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student>
    implements StudentService{

    @Autowired
    StudentMapper studentMapper;

    @Override
    public List<Student> listAll() {
        return studentMapper.listAll();
    }

    @Override
    public List<Student> echoStudent(String id) {
        return studentMapper.echoStudent(id);
    }
}




