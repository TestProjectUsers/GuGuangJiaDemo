package com.demo.controller;

import com.demo.entity.SysUser;
import com.demo.service.SysUserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("manager/sysuser")
public class SysUserController {
   @Autowired
   SysUserService sysUserService;

   @RequestMapping("select")
   @ResponseBody
   public PageInfo<SysUser> selectByCondition(@RequestBody Map<String,Object> params){
       return sysUserService.selectByCondition(params);
   }

}
