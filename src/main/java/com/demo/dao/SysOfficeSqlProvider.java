package com.demo.dao;

import org.springframework.util.StringUtils;

import java.util.Map;

public class SysOfficeSqlProvider {
    public String selectByCondition(Map<String,Object> params){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select so.*,sa.name areaName from sys_office so, sys_area sa where so.area_id = sa.id and so.del_flag = 0 ");
        if (params.containsKey("officeName")&&!StringUtils.isEmpty(params.get("officeName"))){
            stringBuilder.append("and so.name like CONCAT('%',#{officeName},'%')");
        }
        return stringBuilder.toString();
    }
}
