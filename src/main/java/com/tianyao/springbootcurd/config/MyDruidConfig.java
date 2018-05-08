package com.tianyao.springbootcurd.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class MyDruidConfig {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    DataSource dataSource() throws Exception{
        DruidDataSource source = new DruidDataSource();
        source.setFilters("stat,wall.logback");
        return  source;
    }

    @Bean
    ServletRegistrationBean servletRegistrationBean(){
        ServletRegistrationBean<StatViewServlet> druid = new ServletRegistrationBean<>(new StatViewServlet(),"/druid/*");
        Map<String, String> map = new HashMap<>();
        map.put("loginUsername","tianyao");
        map.put("loginPassword","tianyao");
        map.put("allow","");
        //map.put("deny","127.0.0.1");
        druid.setInitParameters(map);
        return  druid;
    }

    FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean<WebStatFilter> bean = new FilterRegistrationBean<>(new WebStatFilter());
        Map<String, String> map = new HashMap<>();
        map.put("exclusions","*.js,*.css,/druid/*");
        bean.setInitParameters(map);
        bean.setUrlPatterns(Arrays.asList("/*"));
        return bean;
    }

}
