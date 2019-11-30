package com.demo.controller;

import com.demo.entity.Statute;
import com.demo.entity.WorkOrder;
import com.demo.service.WorkOrderService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("manager/work")
public class WorkOrderController  {
    @Autowired
    WorkOrderService service;

    @RequestMapping("selectAll")
    public PageInfo<WorkOrder> selectAll(@RequestBody Map<String,Object> params){
        return service.selectByCondition(params);
    }


    @RequestMapping("selectOneMsg")
    public WorkOrder selectOneMsg(Long id){
        return service.selectOneMsg(id);
    }
}
