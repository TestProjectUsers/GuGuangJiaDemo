package com.demo.controller;

import com.demo.entity.SysRole;
import com.demo.entity.SysUser;
import com.demo.service.SysRoleService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("manager/sysrole")
public class SysRoleController {

    @Autowired
    SysRoleService sysRoleService;

    @RequestMapping("selectByCondition")
    @ResponseBody
    public PageInfo<SysRole> selectByCondition(@RequestBody Map<String,Object> params){
        return null;
    }

    @RequestMapping("selectUserByRid")
    @ResponseBody
    public List<SysUser> selectByRoleId(Long id){
        return sysRoleService.selectByRoleId(id);
    }
}
