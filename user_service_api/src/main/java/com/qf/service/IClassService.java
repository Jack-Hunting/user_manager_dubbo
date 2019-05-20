package com.qf.service;

import com.qf.entity.Classes;

import java.util.List;

public interface IClassService {

    List<Classes> getClassList();

    Classes getClaInfoById(Integer id);

    /* type即加减的类型,1表示+一个同学,0表示-一个同学 */
    int updateCount(int cid,int type);
}
