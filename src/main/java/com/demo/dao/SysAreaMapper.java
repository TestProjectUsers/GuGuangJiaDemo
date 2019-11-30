package com.demo.dao;

import com.demo.entity.SysArea;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface SysAreaMapper extends Mapper<SysArea> {
    @Select("select child.*,parent.name parentName from sys_area parent,sys_area child where child.parent_id = parent.id and child.parent_ids like concat('%',#{aid},'%') ")
    List<SysArea> selectByPId(Long aid);



    @Update("update sys_area set parent_ids = REPLACE(parent_id,#{oldParentIds},#{parentIds}) where parent_ids like concat('%',#{id},'%')")
    int upDateParent(SysArea sysArea);

}