package com.ff.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 
 * @TableName depart
 */
@TableName(value ="depart")
@Data
public class Depart implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */
    private Integer parentId;

    /**
     * 名称
     */
    private String name;

    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date creatTime;

    /**
     * 部门
     */
    private String type;

    /**
     * 等级
     */
    private String level;

    /**
     * 位置
     */
    private String place;

    /**
     * 部门路径
     */
    private String depath;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}