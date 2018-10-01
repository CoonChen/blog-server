package com.coon.blog.common.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *  mybatis-plus 配置信息
 */
@Configuration
public class MyBatisPlusConfig {
    /**
     *  mybatis-plus 逻辑删除
     *  Bean配置注入
     */
    @Bean
    public ISqlInjector sqlInjector() {
        return new LogicSqlInjector();
    }

}
