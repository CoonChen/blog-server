package com.coon.blog.common.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

@Configuration
public class JdbcConfig {
    @Autowired
    private Environment environment;

    @Bean
    public DataSource dataSource() {
        String prefix="spring.datasource";
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(environment.getProperty(prefix + ".driver-class-name"));
        dataSource.setUrl(environment.getProperty(prefix + ".url"));
        dataSource.setUsername(environment.getProperty(prefix + ".username"));
        dataSource.setPassword(environment.getProperty(prefix + ".password"));
        dataSource.setMaxActive(20);
        dataSource.setMinIdle(10);
        dataSource.setInitialSize(3);
        dataSource.setRemoveAbandonedTimeout(180);
        dataSource.setLogAbandoned(true);
        return dataSource;
    }
}
