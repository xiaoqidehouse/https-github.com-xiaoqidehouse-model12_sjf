package com.ff.service;

import com.ff.domain.Subject;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author iloveit
* @description 针对表【subject】的数据库操作Service
* @createDate 2024-03-15 15:36:59
*/
public interface SubjectService extends IService<Subject> {

    void savesId(Integer i, Integer id);


    List<Subject> Exlist();


    void removeStudentById(Integer id);


}
