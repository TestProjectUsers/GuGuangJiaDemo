package com.demo.service;

import com.demo.entity.SysRole;
import com.demo.entity.SysUser;

import java.util.List;

public interface SysRoleService extends IService<SysRole> {
    List<SysUser> selectByRoleId(Long id);
}
