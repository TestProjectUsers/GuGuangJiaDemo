import com.demo.config.SpringMabtisConfig;
import com.demo.dao.SysRoleMapper;
import com.demo.entity.SysUser;
import com.demo.service.SysRoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringMabtisConfig.class)
public class TestRole {
    @Autowired
    SysRoleMapper sysRoleMapper;

    @Autowired
    SysRoleService sysRoleService;


    @Test
    public void test2(){
        List<SysUser> sysUsers = sysRoleService.selectByRoleId(1L);
        System.out.println(sysUsers);
    }
}
