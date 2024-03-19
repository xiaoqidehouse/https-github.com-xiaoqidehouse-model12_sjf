package com.ff.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * 
 * @TableName scope
 */
@TableName(value ="scope")
@Data
public class Scope implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */
    private String sName;

    /**
     * 
     */
    private String ms;

    /**
     * 
     */
    private String ks;

    /**
     * 
     */
    private String people;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}