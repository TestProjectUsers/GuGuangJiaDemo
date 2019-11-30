import com.demo.config.SpringMabtisConfig;
import com.demo.dao.SysOfficeMapper;
import com.demo.dao.SysUserMapper;
import com.demo.entity.SysRole;
import com.demo.entity.SysUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringMabtisConfig.class)
public class TestUser {
    @Autowired
    SysUserMapper sysUserMapper;


    @Test
    public void test1(){
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("userName","陈");
        List<SysUser> sysUsers = sysUserMapper.selectByCondition(stringObjectHashMap);
        for (SysUser sysUser : sysUsers) {
            System.out.println(sysUser);
        }
    }


}
