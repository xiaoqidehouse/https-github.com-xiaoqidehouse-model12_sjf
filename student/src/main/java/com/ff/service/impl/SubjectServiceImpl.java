package com.ff.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ff.domain.Subject;
import com.ff.service.SubjectService;
import com.ff.mapper.SubjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author iloveit
* @description 针对表【subject】的数据库操作Service实现
* @createDate 2024-03-15 15:36:59
*/
@Service
public class SubjectServiceImpl extends ServiceImpl<SubjectMapper, Subject>
    implements SubjectService{

    @Autowired
    SubjectMapper subjectMapper;

    @Override
    public void savesId(Integer i, Integer id) {

        subjectMapper.saveId(i,id);

    }

    @Override
    public List<Subject> Exlist() {
        return subjectMapper.exlist();
    }

    @Override
    public void removeStudentById(Integer id) {

        subjectMapper.removeStudentById(id);

    }



}




