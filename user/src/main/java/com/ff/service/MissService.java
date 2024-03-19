package com.ff.service;

import com.ff.domain.Miss;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author iloveit
* @description 针对表【miss】的数据库操作Service
* @createDate 2024-03-13 08:51:39
*/
public interface MissService extends IService<Miss> {

    List<Miss> selectEx();

    List<Miss> selectYear();


}
