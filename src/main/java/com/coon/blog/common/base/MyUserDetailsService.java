package com.coon.blog.common.base;

import com.coon.blog.domain.User;
import com.coon.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("账号在系统中不存在！");
        }
        return new MyUserDetails(user.getUsername(), user.getPassword(), true, true, true, true, getAuthorities());
    }

    /* 获取用户的角色权限, 为了降低实验的难度, 这里去掉了根据用户名获取角色的步骤 */
    private Set<GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authList = new HashSet<>();
        authList.add(new SimpleGrantedAuthority("ROLE_USER"));
        authList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        return authList;
    }
}
