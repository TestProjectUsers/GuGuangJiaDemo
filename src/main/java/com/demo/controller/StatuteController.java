package com.demo.controller;

import com.demo.entity.Result;
import com.demo.entity.Statute;
import com.demo.service.StatuteService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("manager/statute")
public class StatuteController {

    @Autowired
    StatuteService statuteService;

    @RequestMapping("selectAll")
    public PageInfo<Statute> selectAll(@RequestBody  Map<String,Object> params){
        return statuteService.selectAll(params);
    }

    @RequestMapping("insertMsg")
    public int selectAll(@RequestBody Statute statute){
        statute.setDelFlag("0");
        statute.setAreaId(null);
        statute.setCode(null);
        statute.setCreateDate(new Date());
        statute.setUpdateDate(new Date());
        statute.setCreateBy("2,超级管理员");

        return statuteService.insert(statute);
    }
    @RequestMapping("toUpdate")
    public Statute toUpdate(Long id){
        return statuteService.selectByPrimaryKey(id);
    }
    @RequestMapping("update")
    public int update(@RequestBody Statute statute){
        return statuteService.updateByPrimaryKeySelective(statute);
    }
}
