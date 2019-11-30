package com.demo.service.Impl;

import com.demo.dao.SysUserMapper;
import com.demo.entity.SysUser;
import com.demo.service.SysUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class SysUserServiceImpl extends IServiceImpl<SysUser> implements SysUserService {


    @Override
    public PageInfo<SysUser> selectByCondition(@RequestBody Map<String, Object> params) {
        if (StringUtils.isEmpty(params.get("pageNum"))){
            params.put("pageNum",1);
        }
        if (StringUtils.isEmpty(params.get("pageSize"))){
            params.put("pageSize",5);
        }
        PageHelper.startPage((Integer) params.get("pageNum"),(Integer) params.get("pageSize"));
        SysUserMapper sysUserMapper = (SysUserMapper) mapper;
        List<SysUser> sysUsers = ((SysUserMapper) mapper).selectByCondition(params);
        PageInfo<SysUser> sysUserPageInfo = new PageInfo<>(sysUsers);
        return sysUserPageInfo;
    }

}
