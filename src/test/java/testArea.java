import com.demo.config.SpringMabtisConfig;
import com.demo.dao.SysAreaMapper;
import com.demo.entity.SysArea;
import com.demo.service.SysAreaService;
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
public class testArea {
    @Autowired
    SysAreaService sysAreaService;

    @Autowired
    SysAreaMapper sysAreaMapper;

    @Test
    public void testSelectAll(){
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        PageInfo<SysArea> sysAreaPageInfo = sysAreaService.selectByPage(stringObjectHashMap);
        List<SysArea> list = sysAreaPageInfo.getList();
        for (SysArea sysArea : list) {
            System.out.println(sysArea);
        }
    }
    @Test
    public void test2(){
        SysArea sysArea = sysAreaService.selectById(3L);
        System.out.println(sysArea);
    }
}
