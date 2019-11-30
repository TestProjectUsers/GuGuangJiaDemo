package com.demo.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.util.StringUtils;

import java.util.Map;

public class ExamineSqlProvider {
    public String selectByCondition(Map<String, Object> condition) {
//        /*select ex.*,su.name  userName, so.name officeName from examine ex ,sys_user su , sys_office so WHERE  ex.examine_user_id=su.id
//and su.office_id=so.id
//and so.id = 56
//and ex.type = 1
//and su.name like CONCAT('%','工作','%') */


        StringBuilder sb = new StringBuilder();
        sb.append("select ex.*,su.name  UserName, so.name OfficeName from examine ex ,sys_user su , sys_office so WHERE  ex.del_flag=0 and ex.examine_user_id=su.id and su.office_id=so.id");
        if (!StringUtils.isEmpty(condition.get("officeId"))) {
            sb.append(" and so.id = #{officeId} ");
        }
        if (!StringUtils.isEmpty(condition.get("type"))){
            sb.append(" and ex.type = #{type} ");
        }
        if (!StringUtils.isEmpty(condition.get("userName"))){

            sb.append(" and su.name like concat('%',#{userName},'%')");
        }
        System.out.println(sb.toString());
        return sb.toString();
    }
}
