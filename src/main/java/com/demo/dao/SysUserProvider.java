package com.demo.dao;

import org.springframework.util.StringUtils;

import java.util.Map;

public class SysUserProvider {
    public String selectByCondition(Map<String, Object> params) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("SELECT " +
                " su.*, " +
                " so.name OfficeName  " +
                "FROM " +
                " sys_user su " +
                " LEFT JOIN sys_office so ON su.office_id = so.id "
                );
        if (params.containsKey("roleId") && !StringUtils.isEmpty(params.get("roleId"))) {
            stringBuffer.append(" LEFT JOIN sys_user_role sur ON sur.user_id = su.id " +
                                " LEFT JOIN sys_role sr ON sr.id = sur.role_id "+
                                " WHERE su.del_flag = 0 " );
            stringBuffer.append(" and sr.id = #{roleId}");
        }else{
            stringBuffer.append(" WHERE su.del_flag = 0 ");
        }
        if (params.containsKey("officeId") && !StringUtils.isEmpty(params.get("officeId"))) {
            stringBuffer.append(" and so.id = #{officeId}");
        }
        if (params.containsKey("userId") && !StringUtils.isEmpty(params.get("userId"))) {
            stringBuffer.append(" and su.id = #{userId}");
        }
        if (params.containsKey("userName") && !StringUtils.isEmpty(params.get("userName"))) {
            stringBuffer.append(" and su.name like concat ('%',#{userName},'%')");
        }
        return stringBuffer.toString();
    }
}
