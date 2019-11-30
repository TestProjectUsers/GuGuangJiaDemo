package com.demo.service.Impl;

import com.demo.dao.SysAreaMapper;
import com.demo.dao.SysOfficeMapper;
import com.demo.entity.SysArea;
import com.demo.service.SysAreaService;
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
public class SysAreaServiceImpl extends IServiceImpl<SysArea> implements SysAreaService {

    @Autowired
    SysAreaMapper sysAreaMapper;

    @Override
    public PageInfo<SysArea> selectByPage(Map<String, Object> params) {
        if (StringUtils.isEmpty(params.get("pageNum"))){
            params.put("pageNum",1);
        }
        if (StringUtils.isEmpty(params.get("pageSize"))){
            params.put("pageSize",5);
        }
        PageHelper.startPage((Integer) params.get("pageNum"),(Integer) params.get("pageSize"));
        PageInfo<SysArea> sysAreaPageInfo = null;
        if (params.containsKey("aid")&&!StringUtils.isEmpty(params.get("aid"))){
            int aid = (Integer) params.get("aid");
            List<SysArea> sysAreas = sysAreaMapper.selectByPId((long) aid);
            sysAreaPageInfo = new PageInfo<>(sysAreas);
        }
        if (params.containsKey("areaName")&&!StringUtils.isEmpty(params.get("areaName"))){
            SysArea sysArea = new SysArea();
            sysArea.setName((String) params.get("areaName"));
            List<SysArea> select = sysAreaMapper.select(sysArea);
            sysAreaPageInfo = new PageInfo<>(select);
        }else {
            List<SysArea> sysAreas = sysAreaMapper.selectAll();
            sysAreaPageInfo = new PageInfo<>(sysAreas);
        }
        return sysAreaPageInfo;
    }

    @Override
    public SysArea selectById(Long id) {
        return sysAreaMapper.selectByPrimaryKey(id);
    }

    @Override
    public int upDateArea(SysArea sysArea) {
        int i = sysAreaMapper.updateByPrimaryKey(sysArea);
        if (!sysArea.getOldParentIds().equals(sysArea.getParentIds())){
            sysAreaMapper.upDateParent(sysArea);
            i++;
        }
        return i;
    }
}
