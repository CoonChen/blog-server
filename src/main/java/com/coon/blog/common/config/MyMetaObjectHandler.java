package com.coon.blog.common.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
/**
 *  mybatis-plus 自动注入填充
 *  配置Bean
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("createdDate", LocalDateTime.now(), metaObject);
        this.setFieldValByName("enabled", Boolean.TRUE, metaObject);
        this.setFieldValByName("lastModifiedDate", LocalDateTime.now(), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("lastModifiedDate", LocalDateTime.now(), metaObject);
    }
}
