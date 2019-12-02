package com.demo.dao;

import com.demo.entity.SysOffice;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface SysOfficeMapper extends Mapper<SysOffice> {
    @SelectProvider(type = SysOfficeSqlProvider.class,method = "selectByCondition")
    List<SysOffice> selectByCondition(Map<String,Object> params);

    @Select("select  so.*,sa.name areaName from sys_office so ,sys_area sa where so.area_id = sa.id and so.del_flag = 0 and so.id = #{id}")
    SysOffice selectById(Long id);
}