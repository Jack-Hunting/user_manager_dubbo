package com.qf.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.qf.dao.ClaMapper;
import com.qf.entity.Classes;
import com.qf.service.IClassService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @vervion 1.0
 * @date 2019/05/18 10:43
 * @user Jack-Hunting
 */
@Service
public class ClaServiceImpl implements IClassService {

    @Autowired
    ClaMapper claMapper;

    @Override
    public List<Classes> getClassList() {
        List<Classes> list = claMapper.selectList(null);
        return list;
    }

    @Override
    public Classes getClaInfoById(Integer id) {
        Classes cla = claMapper.selectById(id);
        return cla;
    }

    @Override
    public int updateCount(int cid, int type) {
//      通过id得到班级对象
        Classes classes = claMapper.selectById(cid);
//      通过type进行人数的加减
        if(type == 1){
            classes.setStucount(classes.getStucount()+1);
        }else if (type == 2){
            classes.setStucount(classes.getStucount()-1);
        }

        return claMapper.updateById(classes);
    }
}
