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
 * @TableName miss
 */
@TableName(value ="miss")
@Data
public class Miss implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private String sex;

    /**
     * 
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    /**
     * 
     */
    private String home;

    /**
     * 
     */
    private String email;

    /**
     * 
     */
    private String tel;

    /**
     * 
     */
    private String job;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @TableField(exist = false)
    private String xdata;
    @TableField(exist = false)
    private Integer ydata;

    @TableField(exist = false)
    private String x;
    @TableField(exist = false)
    private Integer y;
}