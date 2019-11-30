package com.demo.service.Impl;

import com.demo.dao.ExamineMapper;
import com.demo.entity.Examine;
import com.demo.service.ExamineService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;
@Service
@Transactional
public class ExamineServiceImpl extends IServiceImpl<Examine> implements ExamineService {
    @Override
    public PageInfo<Examine> selectAll(Map<String, Object> params) {
        if (!StringUtils.isEmpty(params.get(params.get("pageNum")))){
            params.put("pageNum",1);
        }
        if (!StringUtils.isEmpty(params.get(params.get("pageSize")))){
            params.put("pageSize",5);
        }
        PageHelper.startPage((Integer) params.get("pageNum"),(Integer) params.get("pageSize"));
        ExamineMapper examineMapper = (ExamineMapper) mapper;
        List<Examine> examines = examineMapper.selectByCondition(params);
        PageInfo<Examine> tPageInfo = new PageInfo<>(examines);
        return tPageInfo;
    }
}
