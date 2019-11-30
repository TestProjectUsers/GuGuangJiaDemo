package com.demo.dao;

import com.demo.entity.Detail;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface DetailMapper extends Mapper<Detail> {
    @Select("select wa.* from detail de ,waste wa ,waste_type wat where de.work_order_ud = #{id} and de.waste_type_id wat.id and de.waste_id = wa.id ")
    List<Detail> selectOneWorkOrederMsg(Long id);
}