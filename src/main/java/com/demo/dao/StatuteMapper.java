package com.demo.dao;

import com.demo.entity.Statute;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.web.bind.annotation.RequestBody;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface StatuteMapper extends Mapper<Statute> {
    @SelectProvider(type = StatuteSqlProvider.class,method = "selectCondition")
    List<Statute> selectCondition (Map<String,Object> params);
}