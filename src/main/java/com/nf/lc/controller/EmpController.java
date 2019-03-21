package com.nf.lc.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nf.lc.entity.Emp;
import com.nf.lc.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/emp")
public class EmpController {

    @Autowired
    private EmpService empService;

    /**
     * 跳转到添加页面 add.jsp
     *
     * @return
     */
    @GetMapping("/goto/insert")
    public ModelAndView gotoInsert() {
        return new ModelAndView("add");
    }

    /**
     * 初始界面，显示列表
     *
     * @return
     */
    @GetMapping("/main")
    public ModelAndView start() {
        ModelAndView modelAndView = new ModelAndView();

        //保存实现分页所需要的信息
        PageInfo<Emp> of = PageInfo.of(empService.selectAll());
        modelAndView.addObject("page", of);


        PageHelper.startPage(1, 3);  //第1页，每页三条
        modelAndView.addObject("emps", empService.selectAll());  //查询出数据进行保存
        modelAndView.setViewName("main");   //写入视图名称，这里是 main.jsp
        return modelAndView;
    }

    /**
     * 通过页数查询数据
     *
     * @param page 第几页
     * @return
     */
    @GetMapping("/main/{page}")
    public ModelAndView start(@PathVariable("page") int page) {
        ModelAndView modelAndView = new ModelAndView();

        PageInfo<Emp> of = PageInfo.of(empService.selectAll());
        modelAndView.addObject("page", of);

        PageHelper.startPage(page, 3);
        modelAndView.addObject("emps", empService.selectAll());
        modelAndView.setViewName("main");
        return modelAndView;
    }


    /**
     * 根据id删除
     *
     * @param id 传入参数
     * @return
     */
    @GetMapping("/deleteByPrimaryKey/{id}")
    public ModelAndView deleteByPrimaryKey(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            if (empService.deleteByPrimaryKey(id) > 0) {
                modelAndView.addObject("msg", "删除成功！"); //成功携带的信息
                modelAndView.setViewName("success");   //返回页面，这里是 success.jsp
            } else {
                modelAndView.addObject("msg", "删除失败！"); //失败携带的信息
                modelAndView.setViewName("error"); //返回页面，这里是 error.jsp
            }

        } catch (Exception ex) {
            modelAndView.addObject("msg", "删除失败！");
            modelAndView.setViewName("error");
        }
        return modelAndView;
    }

    /**
     * 添加对象emp
     *
     * @param emp
     * @return
     */
    @PostMapping("/insert")
    public Object insert(Emp emp) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            if (empService.insert(emp) > 0) {
                modelAndView.addObject("msg", "添加成功！");
                modelAndView.setViewName("success");
            } else {
                modelAndView.addObject("msg", "添加失败！");
                modelAndView.setViewName("error");
            }
        } catch (Exception ex) {
            modelAndView.addObject("msg", "添加失败！");
            modelAndView.setViewName("error");
        }

        return modelAndView;
    }

    /**
     * 根据ID查询并跳转到修改页面
     *
     * @param empId
     * @return
     */
    @GetMapping("/updateByPrimaryId/{empId}")
    public ModelAndView updateByPrimaryId(@PathVariable("empId") int empId) {
        ModelAndView modelAndView = new ModelAndView("update"); //初始化ModelAndView，并传入视图名称 update.jsp
        modelAndView.addObject("emp", empService.selectByPrimaryKey(empId));
        return modelAndView;
    }

    /**
     * 根据id修改全部字段
     *
     * @param emp
     * @return
     */
    @PostMapping(value = "/updateByPrimaryKey")
    public Object updateByPrimaryKey(Emp emp) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            if (empService.updateByPrimaryKey(emp) > 0) {
                modelAndView.addObject("msg", "修改成功！");
                modelAndView.setViewName("success");
            } else {
                modelAndView.addObject("msg", "修改失败！");
                modelAndView.setViewName("error");
            }
        } catch (Exception ex) {
            modelAndView.addObject("msg", "修改失败！");
            modelAndView.setViewName("error");
        }

        return modelAndView;
    }

}
