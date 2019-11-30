import com.demo.config.SpringMabtisConfig;
import com.demo.dao.StatuteMapper;
import com.demo.entity.Statute;
import com.demo.service.StatuteService;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringMabtisConfig.class)
public class testStatute {
    @Autowired
    StatuteService statuteService;

    @Autowired
    StatuteMapper statuteMapper;

    @Autowired
    RedisTemplate redisTemplate;

    @Test
    public void test1(){
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        PageInfo<Statute> statutePageInfo = statuteService.selectAll(stringObjectHashMap);
        List<Statute> list = statutePageInfo.getList();
        for (Statute statute : list) {
            System.out.println(statute);
        }
    }
    @Test
    public void test2(){
        List<Statute> statutes = statuteService.selectAll();
        for (Statute statute : statutes) {
            System.out.println(statute);
        }

//        ValueOperations valueOperations = redisTemplate.opsForValue();
//        valueOperations.set("statute",statutes);
//        System.out.println("---------------------------------------------");
//
//        System.out.println(valueOperations.get("statute"));
    }
    @Test
    public void tests(){
        List<Statute> statutes = statuteService.selectAll();
        for (Statute statute : statutes) {
            System.out.println(statute);
        }
    }
}
