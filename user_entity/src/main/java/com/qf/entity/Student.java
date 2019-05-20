package com.qf.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;

/**
 * @vervion 1.0
 * @date 2019/05/17 21:42
 * @user Jack-Hunting
 */
@Data
public class Student implements Serializable {

    private int id;

    private String name;

    private int age;

    private int cid;

    @TableField(exist = false)
    private Classes cla;
}
