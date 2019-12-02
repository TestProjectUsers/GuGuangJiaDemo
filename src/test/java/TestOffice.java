import com.demo.config.SpringMabtisConfig;
import com.demo.dao.SysOfficeMapper;
import com.demo.entity.SysOffice;
import com.demo.service.SysOfficeService;
import com.demo.service.SysRoleService;
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
public class TestOffice {
    @Autowired
    SysOfficeMapper sysOfficeMapper;

    @Autowired
    SysOfficeService sysOfficeService;

    @Test
    public void Test1(){
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("officeName","新");
        List<SysOffice> sysOffices = sysOfficeMapper.selectByCondition(stringObjectHashMap);
        for (SysOffice sysOffice : sysOffices) {
            System.out.println(sysOffice);
        }
    }

    @Test
    public void Test2(){
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("officeName","新");
        PageInfo<SysOffice> sysOfficePageInfo = sysOfficeService.selectByCondition(stringObjectHashMap);
        List<SysOffice> list = sysOfficePageInfo.getList();
        for (SysOffice sysOffice : list) {
            System.out.println(sysOffice);
        }
    }

    @Test
    public void Test3(){
        SysOffice sysOffice = sysOfficeMapper.selectById(11L);
        System.out.println(sysOffice);
    }

    @Test
    public void Test4(){
        SysOffice sysOffice = sysOfficeService.selectById(11L);
        System.out.println(sysOffice);
    }
}
