package com.demo.dao;

import com.demo.entity.SysRole;
import com.demo.entity.SysUser;
import org.apache.ibatis.annotations.*;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface  SysUserMapper extends Mapper<SysUser> {

    @SelectProvider(type = SysUserProvider.class,method = "selectByCondition")
    @Results({
            @Result(column = "id",property = "id"),
            @Result(property = "Roles",column = "id",many = @Many(select = "com.demo.dao.SysRole.selectNameByUserId"))
    })
    List<SysUser> selectByCondition(Map<String,Object> params);



}