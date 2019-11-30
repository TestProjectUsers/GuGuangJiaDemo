package com.demo.dao;

import com.demo.entity.Examine;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface ExamineMapper extends Mapper<Examine> {
    @SelectProvider(type = ExamineSqlProvider.class,method = "selectByCondition")
    List<Examine> selectByCondition(Map<String,Object> condition);
}