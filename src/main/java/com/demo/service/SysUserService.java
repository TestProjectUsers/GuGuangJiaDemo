package com.demo.service;

import com.demo.entity.SysUser;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

public interface SysUserService extends IService<SysUser> {
    PageInfo<SysUser> selectByCondition(Map<String,Object> params);

}
