package com.demo.dao;

import com.demo.entity.WorkOrder;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface WorkOrderMapper extends Mapper<WorkOrder> {
    @SelectProvider(type = WorkOrderProvider.class,method = "selectByCondition")
    List<WorkOrder> selectByCondition(Map<String,Object> params);

    @Select("select wo.*,su.name createName ,su.phone createPhone, yu.name transportName ,yu.phone transportPhone,sus.name recipientName,sus.phone recipientPhone, soff.name createOfficeName , soe.name transportOfficeName, sff.name recipientOfficeName from work_order wo left join sys_user su on wo.create_user_id = su.id left join sys_user yu on wo.transport_user_id = yu.id left join  sys_user sus on wo.recipient_user_id = sus.id left join sys_office soff on su.office_id = soff.id left join sys_office soe on yu.office_id = soe.id left join sys_office sff on sus.office_id = sff.id where wo.del_flag=0" +
            " and wo.id=#{id} ")
    WorkOrder selectOneMsg(Long id );
}