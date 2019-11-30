import com.demo.config.SpringMabtisConfig;
import com.demo.dao.WorkOrderMapper;
import com.demo.entity.WorkOrder;
import com.demo.service.WorkOrderService;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringMabtisConfig.class)
public class testWorkOrder {
    @Autowired
    WorkOrderService workOrderService;

    @Autowired
    WorkOrderMapper Mapper;

    @Test
    public void Test(){
        HashMap<String , Object> stringObjectHashMap = new HashMap<>();
//        List<WorkOrder> workOrders = Mapper.selectByCondition(stringObjectHashMap);
        PageInfo<WorkOrder> workOrderPageInfo = workOrderService.selectByCondition(stringObjectHashMap);
        List<WorkOrder> list = workOrderPageInfo.getList();
        for (WorkOrder workOrder : list) {
            System.out.println(workOrder);
        }
    }
}
