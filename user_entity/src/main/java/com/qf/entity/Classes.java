package com.qf.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @vervion 1.0
 * @date 2019/05/17 21:42
 * @user Jack-Hunting
 */
@Data
public class Classes implements Serializable {

    private int id;

    private String cname;

    private int stucount;
}
