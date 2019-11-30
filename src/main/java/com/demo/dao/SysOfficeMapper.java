package com.demo.dao;

import com.demo.entity.SysOffice;
import org.apache.ibatis.annotations.SelectProvider;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface SysOfficeMapper extends Mapper<SysOffice> {
    @SelectProvider(type = SysOfficeSqlProvider.class,method = "selectByCondition")
    List<SysOffice> selectByCondition(Map<String,Object> params);
}