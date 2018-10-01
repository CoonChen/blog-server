package com.coon.blog.common.utils;

import com.coon.blog.common.base.security.MyUserDetails;
import com.google.common.collect.Maps;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Map;

public class RequestUtils {

    public static String getUsername() {
        return String.valueOf(getSecurityMap().get("username"));
    }

    private  static Map<String,Object> getSecurityMap() {
        Map<String,Object> map= Maps.newHashMap();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal().getClass().isAssignableFrom(MyUserDetails.class)) {
            MyUserDetails myUserDetails=((MyUserDetails) authentication.getPrincipal());
            map=ReflectionUtil.getPropertyMap(myUserDetails);
        }
        return map;
    }

}
