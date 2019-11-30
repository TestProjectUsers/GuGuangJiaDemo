package com.demo.controller;

import com.demo.entity.AppVersion;
import com.demo.entity.Result;
import com.demo.entity.Statute;
import com.demo.service.AppVersionService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("manager/app")
public class AppVersionController {
    @Autowired
    AppVersionService appVersionService;

////    public List<AppVersion> SelectAll(){
////        return appVersionService.selectAll();
////    }

    @RequestMapping("selectAll")
    @ResponseBody
    public PageInfo<AppVersion> selectAll(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "3") Integer pageSize){
        return appVersionService.selectAll(pageNum,pageSize);
    }

    @RequestMapping("toUpdate")
    @ResponseBody
    public AppVersion toUpdate(Long id){
        return appVersionService.selectByPrimaryKey(id);
    }
    @RequestMapping("update")
    @ResponseBody
    public Result update(@RequestBody AppVersion appVersion){
        int i = appVersionService.updateByPrimaryKey(appVersion);
        Result result = new Result();
        if (i>0){
            result.setMsg("操作成功");
            result.setSuccess(true);
        }
        return result;
    }
    @RequestMapping("deleteMsg")
    @ResponseBody
    public Result deleteMsg(Long id){
        AppVersion appVersion = new AppVersion();
        appVersion.setId(id);
        appVersion.setDelFlag("1");
        appVersion.setUpdateDate(new Date());
        int deletefalg = appVersionService.delete(appVersion);
        Result result = new Result();
        if (deletefalg>0){
            result.setSuccess(true);
            result.setMsg("操作成功");
        }
        return result;
    }
    @RequestMapping("insertMsg")
    @ResponseBody
    public Result insertMsg(@RequestBody AppVersion appVersion){
        appVersion.setUpdateDate(new Date());
        appVersion.setCreateDate(new Date());
        appVersion.setDelFlag("0");
        appVersion.setCreateBy("sys");
        int insert = appVersionService.insert(appVersion);
        Result result = new Result();
        if (insert>0){
            result.setMsg("操作成功");
            result.setSuccess(true);
        }
        return result;
    }

}
