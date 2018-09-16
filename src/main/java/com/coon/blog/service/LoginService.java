package com.coon.blog.service;

import com.coon.blog.common.utils.RequestUtils;
import com.coon.blog.domain.User;
import com.coon.blog.repository.UserRepository;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Map;

@Service
@Transactional(readOnly = true)
public class LoginService {
    @Autowired
    private UserRepository userRepository;

    public Map<String, Object> getUserInformation() {
        Map<String, Object> resultData = Maps.newHashMap();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth instanceof AnonymousAuthenticationToken) {
            resultData.put("isLogin", false);
        } else {
            User user = new User();
            user.setUsername(RequestUtils.getUsername());
            resultData.put("isLogin", true);
            resultData.put("currentDate", LocalDateTime.now().toString());
            resultData.put("user", user);
        }
        return resultData;
    }

    @Transactional(rollbackFor = Exception.class)
    public Map<String, Object> register(User user) {
        Map<String, Object> resultData = Maps.newHashMap();
        String username = user.getUsername();
        User sysUser = userRepository.findByUsername(username);
        if (sysUser != null) {
            resultData.put("success", false);
            resultData.put("message", "系统中已存在该账号！");
            return resultData;
        }
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        resultData.put("success", true);
        resultData.put("message", "注册成功！");
        return resultData;
    }
}
