package com.demo.dao;

import com.demo.entity.Qualification;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.Map;

public interface QualificationMapper extends Mapper<Qualification> {
    @Select("select su.name uploadUserName ,sus.`name` checkUserName from qualification qu LEFT JOIN sys_user su on  qu.upload_user_id=su.id LEFT JOIN sys_user sus ON qu.check_user_id=sus.id where qu.id=#{id}")
    Map<String, Object> selectNames(Long id);
}