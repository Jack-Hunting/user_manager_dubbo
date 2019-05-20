package com.qf.service;

import com.qf.entity.Student;

import java.util.List;

/**
 * @vervion 1.0
 * @date 2019/05/17 21:46
 * @user Jack-Hunting
 */
public interface IUserService {

    List<Student> getStuList();

    int addUser(Student student);

    int deleteUser(Integer id);
}
