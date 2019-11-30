package com.demo.service.Impl;

import com.demo.dao.DetailMapper;
import com.demo.dao.TransferMapper;
import com.demo.dao.WorkOrderMapper;
import com.demo.entity.Detail;
import com.demo.entity.Transfer;
import com.demo.entity.WorkOrder;
import com.demo.service.WorkOrderService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;
@Service
@Transactional
public class WorkOrderServiceImpl extends IServiceImpl<WorkOrder>  implements WorkOrderService {

    @Autowired
    DetailMapper detailMapper;

    @Autowired
    TransferMapper transferMapper;

    @Override
    public PageInfo<WorkOrder> selectByCondition(Map<String, Object> params) {
        if (StringUtils.isEmpty(params.get("pageNum"))){
            params.put("pageNum",1);
        }
        if (StringUtils.isEmpty(params.get("pageSize"))){
            params.put("pageSize",5);
        }
        PageHelper.startPage((Integer) params.get("pageNum"),(Integer) params.get("pageSize"));
        WorkOrderMapper workOrderMapper = (WorkOrderMapper) mapper;
        List<WorkOrder> workOrders = ((WorkOrderMapper) mapper).selectByCondition(params);
        PageInfo<WorkOrder> workOrderPageInfo = new PageInfo<>(workOrders);
        return workOrderPageInfo;
    }

    @Override
    public WorkOrder selectOneMsg(Long id) {
        WorkOrderMapper workOrderMapper = (WorkOrderMapper) mapper;
        WorkOrder workOrder = ((WorkOrderMapper) mapper).selectOneMsg(id);
        List<Detail> detailList = detailMapper.selectOneWorkOrederMsg(id);
        workOrder.setDetails(detailList);
        List<Transfer> transferList = transferMapper.selectOneWorkOrderMsg(id);
        workOrder.setTransfers(transferList);
        return workOrder;
    }
}
