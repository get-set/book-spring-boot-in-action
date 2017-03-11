package com.getset.security.service;

import com.getset.security.dao.SysUserRepository;
import com.getset.security.domain.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * 针对用户处理。
 * Created by kang on 17-3-11.
 */
@Service
public class SysUserService implements UserDetailsService {

    @Autowired
    SysUserRepository sysUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser user = sysUserRepository.findByUsername(username);
        if (user == null)
            throw new UsernameNotFoundException("用户名不存在。");
        return user;
    }
}
