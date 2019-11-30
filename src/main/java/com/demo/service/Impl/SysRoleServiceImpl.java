package com.demo.service.Impl;

import com.demo.dao.SysRoleMapper;
import com.demo.dao.SysUserMapper;
import com.demo.entity.SysRole;
import com.demo.entity.SysUser;
import com.demo.service.SysRoleService;
import com.demo.service.SysUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class SysRoleServiceImpl extends IServiceImpl<SysRole> implements SysRoleService {
    @Override
    public List<SysUser> selectByRoleId(Long id) {
        SysRoleMapper SysRoleMapper = (SysRoleMapper) mapper;
        List<SysUser> sysUsers = ((SysRoleMapper) mapper).selectByRoleId(id);
        return sysUsers;
    }
}
