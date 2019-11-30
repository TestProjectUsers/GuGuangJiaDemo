package com.demo.service.Impl;

import com.demo.dao.AppVersionMapper;
import com.demo.entity.AppVersion;
import com.demo.service.AppVersionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AppVersionServiceImpl extends IServiceImpl<AppVersion> implements AppVersionService {
    @Override
    public PageInfo<AppVersion> selectAll(Integer pageNum, Integer pageSize) {
        AppVersion appVersion = new AppVersion();
        appVersion.setDelFlag("0");
        PageHelper.startPage(pageNum,pageSize);
        List<AppVersion> appVersions = mapper.select(appVersion);

        PageInfo<AppVersion> appVersionPageInfo = new PageInfo<>(appVersions);

        return appVersionPageInfo;
    }

//    @Autowired
//    AppVersionMapper appVersionMapper;
//
//    public List<AppVersion> selectAll() {
//        return appVersionMapper.selectAll();
//    }
}
