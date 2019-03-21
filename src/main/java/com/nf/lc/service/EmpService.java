package com.nf.lc.service;

import com.nf.lc.entity.Emp;

import java.util.List;

public interface EmpService {

    int deleteByPrimaryKey(Integer id);

    int insert(Emp emp);

    Emp selectByPrimaryKey(Integer id);

    List<Emp> selectAll();

    int updateByPrimaryKey(Emp emp);
}