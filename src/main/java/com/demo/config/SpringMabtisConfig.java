package com.demo.config;

import com.alibaba.druid.pool.DruidDataSource;

import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.plugin.Interceptor;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.mapper.session.Configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
@org.springframework.context.annotation.Configuration
@MapperScan(basePackages = "com.demo.dao")
@ComponentScan(basePackages ={ "com.demo.service","com.demo.util"})
@EnableTransactionManagement
@PropertySource(value = "classpath:sys.properties",encoding = "UTF-8")
@Import({SpringRedisConfig.class,SpringCache.class})
public class SpringMabtisConfig {
    @Bean
    public DruidDataSource getDateSource(){
        DruidDataSource druidDataSource = new DruidDataSource();

        InputStream resourceAsStream = SpringMabtisConfig.class.getClassLoader().getResourceAsStream("db.properties");
        Properties properties = new Properties();
        try {
            properties.load(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        druidDataSource.configFromPropety(properties);
        return druidDataSource;
    }

    @Bean
    public SqlSessionFactoryBean getFactoryBean(DruidDataSource dataSource){
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();

        //设置分页插件   分页拦截器  类似过滤器
        PageInterceptor pageInterceptor = new PageInterceptor();
        pageInterceptor.setProperties(new Properties());
        sqlSessionFactoryBean.setPlugins(new Interceptor[] {pageInterceptor});


        Configuration configuration = new Configuration();
        configuration.setMapUnderscoreToCamelCase(true);

        sqlSessionFactoryBean.setConfiguration(configuration);
        sqlSessionFactoryBean.setTypeAliasesPackage("com.demo.entity");
        sqlSessionFactoryBean.setDataSource(dataSource);
        return  sqlSessionFactoryBean;
    }

    @Bean
    public DataSourceTransactionManager getTransactionManager(DruidDataSource druidDataSource){
        return new DataSourceTransactionManager(druidDataSource);
    }
}
