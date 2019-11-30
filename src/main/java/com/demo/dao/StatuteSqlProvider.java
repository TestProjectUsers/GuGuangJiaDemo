package com.demo.dao;

import org.springframework.util.StringUtils;

import java.util.Map;

public class StatuteSqlProvider  {
    public String selectCondition(Map<String,Object> params){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" select * from statute ");
        if (!StringUtils.isEmpty(params.get("type"))){
            stringBuffer.append(" where type = #{type}");
        }
        return stringBuffer.toString();
    }
}
