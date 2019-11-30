package com.demo.dao;

import org.springframework.util.StringUtils;

import java.util.Map;

public class WorkOrderProvider {
    public String selectByCondition(Map<String,Object> params){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("select wo.*,su.name createName ,su.phone createPhone, yu.name transportName ,yu.phone transportPhone,sus.name recipientName,sus.phone recipientPhone, soff.name createOfficeName , soe.name transportOfficeName, sff.name recipientOfficeName from work_order wo left join sys_user su on wo.create_user_id = su.id left join sys_user yu on wo.transport_user_id = yu.id left join  sys_user sus on wo.recipient_user_id = sus.id left join sys_office soff on su.office_id = soff.id left join sys_office soe on yu.office_id = soe.id left join sys_office sff on sus.office_id = sff.id where wo.del_flag=0 ");
        if (!StringUtils.isEmpty(params.get("type"))){
            stringBuffer.append(" and wo.status = #{type}");
        }
        if (!StringUtils.isEmpty(params.get("BeginTime"))){
            stringBuffer.append(" and wo.create_date > #{BeginTime}");
        }
        if (!StringUtils.isEmpty(params.get("EndTime"))){
            stringBuffer.append(" and wo.create_date > #{EndTime}");
        }
        if (!StringUtils.isEmpty(params.get("name"))){
            stringBuffer.append(" and ( soff.name = #{name} or soe.name =#{name} or sff.name = #{name} )");
        }
        return stringBuffer.toString();
    }
}
