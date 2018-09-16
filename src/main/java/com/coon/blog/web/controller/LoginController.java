package com.coon.blog.web.controller;

import com.coon.blog.domain.Test;
import com.coon.blog.domain.User;
import com.coon.blog.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "isLogin")
    public Boolean isLogin() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth != null && !(auth instanceof AnonymousAuthenticationToken);
    }

    @RequestMapping(value = "getUserInformation")
    public Map<String,Object> getUserInformation() {
        return loginService.getUserInformation();
    }

    @RequestMapping(value = "register")
    public Map<String,Object> register(User user) {
        return loginService.register(user);
    }

    @RequestMapping(value = "test")
    public void test(@RequestBody Test test) {
        Test demo = new Test();
        demo = test;
        System.out.println(demo);
    }

}
