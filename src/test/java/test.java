import com.alibaba.druid.pool.DruidDataSource;
import com.demo.config.SpringMabtisConfig;
import com.demo.controller.AppVersionController;
import com.demo.dao.AppVersionMapper;
import com.demo.entity.AppVersion;
import com.demo.service.AppVersionService;
import com.demo.service.Impl.AppVersionServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.persistence.Table;
import java.sql.SQLException;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringMabtisConfig.class)
public class test {
    @Autowired
    DruidDataSource druidDataSource;

    @Autowired
    SqlSessionFactoryBean factoryBean;

    @Autowired
    AppVersionMapper appVersionMapper;

    @Autowired
    AppVersionService appVersionService;

    @Test
    public void testConn(){
        try {
            System.out.println(druidDataSource.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFactorBean(){
        try {
            System.out.println(factoryBean.getObject().openSession().getConnection());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testFactorBean1(){
        try {
            Class<?> aClass = Class.forName("org.apache.commons.fileupload.FileItemFactory");
            System.out.println(aClass);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSelectAll(){
        PageHelper.startPage(1,3);
        List<AppVersion> appVersions = appVersionMapper.selectAll();
        PageInfo<AppVersion> appVersionPageInfo = new PageInfo<>(appVersions);
        List<AppVersion> list = appVersionPageInfo.getList();
        for (AppVersion appVersion : list) {
            System.out.println(appVersion);
        }
    }

}
