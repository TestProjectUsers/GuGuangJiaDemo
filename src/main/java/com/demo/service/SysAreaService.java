package com.demo.service;

import com.demo.entity.SysArea;
import com.github.pagehelper.PageInfo;

import java.util.Map;

public interface SysAreaService  extends IService<SysArea>{
    PageInfo<SysArea> selectByPage(Map<String,Object> params);

    SysArea selectById(Long id);

    int upDateArea(SysArea sysArea);
}
