package com.demo.dao;

import com.demo.entity.Transfer;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface TransferMapper extends Mapper<Transfer> {
    @Select("select * from transfer tr,sys_user su where tr.work_order_id=#{id} and tr.oprate_user_id = su.id  order by tr.create_date desc")
    List<Transfer> selectOneWorkOrderMsg(Long id);
}