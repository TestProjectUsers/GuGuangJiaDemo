package com.demo.controller;

import com.demo.entity.SysArea;
import com.demo.service.SysAreaService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("manager/sysarea")
public class SysAreaController {

    @Autowired
    SysAreaService sysAreaService;

    @RequestMapping("selectAllArea")
    public List<SysArea> selectAll(){
        return sysAreaService.selectAll();
    }

    @RequestMapping("selectByPage")
    public PageInfo<SysArea> selectByPage(@RequestBody  Map<String,Object> params){
        return sysAreaService.selectByPage(params);
    }

    @RequestMapping("selectById")
    public SysArea selectById(Long id){
        return sysAreaService.selectById(id);
    }

    @RequestMapping("upDateMsg")
    public int upDateMsg(SysArea sysArea){
        return sysAreaService.upDateArea(sysArea);
    }
}
