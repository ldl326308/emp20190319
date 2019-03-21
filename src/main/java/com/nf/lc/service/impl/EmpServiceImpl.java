package com.nf.lc.service.impl;

import com.nf.lc.dao.EmpMapper;
import com.nf.lc.entity.Emp;
import com.nf.lc.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    /**
     * 删除操作 根据id删除
     *
     * @param id
     * @return
     */
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return empMapper.deleteByPrimaryKey(id);
    }

    /**
     * 添加操作
     *
     * @param emp
     * @return
     */
    @Override
    public int insert(Emp emp) {
        return empMapper.insert(emp);
    }

    /**
     * 根据id查询操作
     *
     * @param id
     * @return
     */
    @Override
    public Emp selectByPrimaryKey(Integer id) {
        return empMapper.selectByPrimaryKey(id);
    }

    /**
     * 全部查询操作
     *
     * @return
     */
    @Override
    public List<Emp> selectAll() {
        return empMapper.selectAll();
    }

    /**
     * 修改操作
     *
     * @param emp
     * @return
     */
    @Override
    public int updateByPrimaryKey(Emp emp) {
        return empMapper.updateByPrimaryKey(emp);
    }
}
