package com.demo.controller;

import com.demo.dao.SysOfficeMapper;
import com.demo.dao.SysUserMapper;
import com.demo.entity.SysOffice;
import com.demo.service.SysOfficeService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("manager/sysoffice")
public class SysOfficeController  {

    @Autowired
    SysOfficeService sysOfficeService;


    @ResponseBody
    @RequestMapping("list")
    public List<SysOffice> selectAll(){
        return sysOfficeService.selectAll();
    }

    @RequestMapping("selectByCondition")
    @ResponseBody
    public PageInfo<SysOffice> selectByCondition(@RequestBody  Map<String,Object> params){
        return sysOfficeService.selectByCondition(params);
    }

    @RequestMapping("toUpdate")
    @ResponseBody
    public SysOffice selectById(Long id){
        return sysOfficeService.selectById(id);
    }
}
