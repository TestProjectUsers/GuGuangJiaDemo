import com.demo.config.SpringMabtisConfig;
import com.demo.dao.ExamineMapper;
import com.demo.entity.Examine;
import com.demo.service.ExamineService;
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
public class testExamine {

    @Autowired
    ExamineMapper examineMapper;

    @Autowired
    ExamineService service;

    @Test
    public void test1(){
        HashMap<String, Object> StringObjectHashMap = new HashMap<>();
        StringObjectHashMap.put("userName","工作");
        PageInfo<Examine> examinePageInfo = service.selectAll(StringObjectHashMap);
        List<Examine> list = examinePageInfo.getList();
        for (Examine examine : list) {
            System.out.println(examine);
        }
    }
}
