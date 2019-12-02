package com.demo.service.Impl;

import com.demo.dao.SysOfficeMapper;
import com.demo.entity.SysOffice;
import com.demo.service.SysOfficeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class SysOfficeServiceImpl extends IServiceImpl<SysOffice> implements SysOfficeService {


    @Override
    public PageInfo<SysOffice> selectByCondition(Map<String, Object> params) {
        if (StringUtils.isEmpty(params.get("pageNum"))){
            params.put("pageNum",1);
        }
        if (StringUtils.isEmpty(params.get("pageSize"))){
            params.put("pageSize",5);
        }
        PageHelper.startPage((Integer) params.get("pageNum"),(Integer) params.get("pageSize"));
        SysOfficeMapper sysOfficeMapper = (SysOfficeMapper) mapper;
        List<SysOffice> sysOffices = ((SysOfficeMapper) mapper).selectByCondition(params);
        PageInfo<SysOffice> sysOfficePageInfo = new PageInfo<>(sysOffices);
        return sysOfficePageInfo;
    }

    @Override
    public SysOffice selectById(Long id) {
        SysOfficeMapper sysOfficeMapper = (SysOfficeMapper) mapper;
        return ((SysOfficeMapper) mapper).selectById(id);
    }
}
