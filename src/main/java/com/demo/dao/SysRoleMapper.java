package com.demo.dao;

import com.demo.entity.SysRole;
import com.demo.entity.SysUser;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface SysRoleMapper extends Mapper<com.demo.entity.SysRole> {

    @SelectProvider(type = SysRoleSqlProvider.class,method = "selectByCondition")
    List<SysRole> selectByCondition(Map<String,Object> params);

    @Select("select sr.name from sys_user su left join sys_user_role sur on su.id = sur.user_id left join sys_role  sr on sur.role_id = sr.id where su.id = #{id}")
    List<com.demo.entity.SysRole> selectNameByUserId(long id);

    @Select("select su.* from sys_role sr,sys_user su,sys_user_role sur where sr.id=sur.role_id and sur.user_id=su.id and sr.id = #{id}")
    List<SysUser> selectByRoleId(Long id);
}
