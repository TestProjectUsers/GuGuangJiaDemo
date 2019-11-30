package com.demo.controller;

import com.demo.dao.ExamineMapper;
import com.demo.entity.Examine;
import com.demo.service.ExamineService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("manager/examine")
public class ExamineController {

    @Autowired
    ExamineService examineService;

    @Autowired
    ExamineMapper examineMapper;


    @RequestMapping("select")
    public PageInfo<Examine> select(@RequestBody Map<String,Object> params){
        return examineService.selectAll(params);
    }

    @RequestMapping("selectCondition")
    public List<Examine> selectCondition(@RequestBody Map<String,Object> condition){
         return examineMapper.selectByCondition(condition);
    }
}
