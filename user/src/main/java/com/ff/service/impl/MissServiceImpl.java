package com.ff.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ff.domain.Miss;
import com.ff.service.MissService;
import com.ff.mapper.MissMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author iloveit
* @description 针对表【miss】的数据库操作Service实现
* @createDate 2024-03-13 08:51:39
*/
@Service
public class MissServiceImpl extends ServiceImpl<MissMapper, Miss>
    implements MissService{

    @Autowired
    MissMapper missMapper;

    @Override
    public List<Miss> selectEx() {
        return missMapper.selectEx();
    }

    @Override
    public List<Miss> selectYear() {
        return missMapper.selectYear();
    }
}




