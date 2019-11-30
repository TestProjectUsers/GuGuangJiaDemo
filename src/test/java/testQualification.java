import com.demo.config.SpringMabtisConfig;
import com.demo.dao.QualificationMapper;
import com.demo.entity.Qualification;
import com.demo.service.QualificationService;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringMabtisConfig.class)
public class testQualification {

    @Autowired
    QualificationService service;

    @Autowired
    QualificationMapper qualificationMapper;


    @Test
    public void testExample(){
        Example example = new Example(Qualification.class);
        Example.Criteria criteria = example.createCriteria().andEqualTo("type",3);
        criteria.andEqualTo("check",2).
                andGreaterThan("updateDate","2017-01-11").
                andLessThan("updateDate","2018-12-30");

        List<Qualification> qualifications = qualificationMapper.selectByExample(example);
        for (Qualification qualification : qualifications) {
            System.out.println(qualification);
        }
    }
    @Test
    public void test(){
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("pageNum",1);
        hashMap.put("pageSize",3);
        hashMap.put("type",3);
        hashMap.put("check",2);
        hashMap.put("BeginTime","2017-01-11");
        hashMap.put("EndTime","2018-12-30");
        PageInfo<Qualification> qualificationPageInfo = service.selectCondition(hashMap);
        List<Qualification> list = qualificationPageInfo.getList();
        for (Qualification qualification : list) {
            System.out.println(qualification);
        }

    }
}
