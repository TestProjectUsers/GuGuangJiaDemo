package com.demo.service.Impl;

import com.demo.dao.SysOfficeMapper;
import com.demo.entity.SysOffice;
import com.demo.service.SysOfficeService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Map;

@Service
@Transactional
public class SysOfficeServiceImpl extends IServiceImpl<SysOffice> implements SysOfficeService {
    @Autowired
    SysOfficeMapper sysOfficeMapper;

    @Override
    public PageInfo<SysOffice> selectByCondition(Map<String, Object> params) {
        if (params.containsKey("pageNum")&&!StringUtils.isEmpty(params.get("pageNum"))){
            params.put("pageNum",1);
        }
        if (params.containsKey("pageSize")&&!StringUtils.isEmpty(params.get("pageSize"))){
            params.put("pageSize",5);
        }


        return null;
    }
}
