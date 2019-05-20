package com.qf.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qf.entity.Classes;
import com.qf.entity.Student;
import com.qf.service.IClassService;
import com.qf.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @vervion 1.0
 * @date 2019/05/18 15:15
 * @user Jack-Hunting
 */
@Controller
@RequestMapping("/stu")
public class UserController {

    @Reference
    IUserService userService;

    @Reference
    IClassService classService;

    @RequestMapping("/getUserList")
    public String getUserList(Model model){
        List<Student> stuList = userService.getStuList();
        model.addAttribute("list",stuList);
        return "stulist";
    }

    @RequestMapping("/getClaList")
    public String getClaList(Model model){
        List<Classes> classList = classService.getClassList();
        model.addAttribute("clas",classList);
        return "stuadd";
    }
    @RequestMapping("/addUser")
    public String addUser(Student student){
        userService.addUser(student);
        return "redirect:/stu/getUserList";
    }

    @RequestMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable String id){
        userService.deleteUser(Integer.parseInt(id));
        return "redirect:/stu/getUserList";
    }
}
