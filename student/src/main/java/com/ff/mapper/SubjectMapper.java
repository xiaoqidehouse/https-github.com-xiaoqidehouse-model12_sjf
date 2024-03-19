package com.ff.mapper;

import com.ff.domain.Subject;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author iloveit
* @description 针对表【subject】的数据库操作Mapper
* @createDate 2024-03-15 15:36:59
* @Entity com.ff.domain.Subject
*/
public interface SubjectMapper extends BaseMapper<Subject> {

    void saveId(Integer i, Integer id);

    List<Subject> exlist();

    void removeStudentById(Integer id);

}




