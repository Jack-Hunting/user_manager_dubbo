package com.qf.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.qf.dao.StuMapper;
import com.qf.entity.Classes;
import com.qf.entity.Student;
import com.qf.service.IClassService;
import com.qf.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @vervion 1.0
 * @date 2019/05/18 09:14
 * @user Jack-Hunting
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    StuMapper stuMapper;

    @Reference
    IClassService classService;

    @Override
    public List<Student> getStuList() {
        List<Student> students = stuMapper.selectList(null);

        for(Student stu : students){
            int cid = stu.getCid();
            Classes cla = classService.getClaInfoById(cid);
            stu.setCla(cla);
        }
        return students;
    }

    @Override
    public int addUser(Student student) {
        int insert = stuMapper.insert(student);
//        添加完学生后.记得给班级增加一个人数
        classService.updateCount(student.getCid(),1);
        return insert;
    }

    @Override
    public int deleteUser(Integer id) {
        Student student = stuMapper.selectById(id);

        int i = stuMapper.deleteById(id);

        classService.updateCount(student.getCid(),2);
        return i;
    }
}
