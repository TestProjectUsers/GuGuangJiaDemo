package com.demo.controller;

import com.demo.entity.Qualification;
import com.demo.entity.Result;
import com.demo.service.QualificationService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("manager/qualification")
public class QualificationController {

    @Autowired
    QualificationService qualificationService;

    @RequestMapping("select")
//    @ResponseBody
    public PageInfo<Qualification> select(@RequestBody Map<String,Object> params){
        return qualificationService.selectCondition(params);
    }

    @RequestMapping("toUpdate")
//    @ResponseBody
    public Qualification toUpdate(Long id){
        return qualificationService.selectByPrimaryKey(id);
    }


    @RequestMapping("date")
//    @ResponseBody
    public Result update(@RequestBody Qualification qualification){
        qualification.setAddress(null);
        int i = qualificationService.updateByPrimaryKeySelective(qualification);
        Result result = new Result();
        if (i>0){
            result.setSuccess(true);
            result.setMsg("更新成功");
        }
        return result;
    }
}
