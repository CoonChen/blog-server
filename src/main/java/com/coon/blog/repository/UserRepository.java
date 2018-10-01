package com.coon.blog.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.coon.blog.domain.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface UserRepository extends BaseMapper<User> {
    User findByUsername(@Param(value = "username") String username);
}
