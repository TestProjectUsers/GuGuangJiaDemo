package com.demo.service;

import com.demo.entity.Qualification;
import com.github.pagehelper.PageInfo;

import java.util.Map;

public interface QualificationService extends IService<Qualification> {

    PageInfo<Qualification> selectCondition(Map<String,Object> params);
}
