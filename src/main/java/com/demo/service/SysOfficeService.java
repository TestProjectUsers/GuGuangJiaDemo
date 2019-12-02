package com.demo.service;

import com.demo.entity.SysOffice;
import com.github.pagehelper.PageInfo;

import java.util.Map;

public interface SysOfficeService extends IService<SysOffice> {

    PageInfo<SysOffice> selectByCondition(Map<String,Object> params);


    SysOffice selectById(Long id );
}
