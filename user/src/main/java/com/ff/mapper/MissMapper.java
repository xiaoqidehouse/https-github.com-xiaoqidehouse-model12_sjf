package com.ff.mapper;

import com.ff.domain.Miss;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author iloveit
* @description 针对表【miss】的数据库操作Mapper
* @createDate 2024-03-13 08:51:39
* @Entity com.ff.domain.Miss
*/
public interface MissMapper extends BaseMapper<Miss> {

    List<Miss> selectEx();


    List<Miss> selectYear();


}




