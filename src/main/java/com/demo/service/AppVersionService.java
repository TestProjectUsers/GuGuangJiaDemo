package com.demo.service;

import com.demo.entity.AppVersion;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface AppVersionService extends IService<AppVersion>{

//    List<AppVersion> selectAll();

    PageInfo<AppVersion> selectAll(Integer pageNum,Integer pageSize);
}
