package com.getset.security.dao;

import com.getset.security.domain.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 数据访问。
 * Created by kang on 17-3-11.
 */
public interface SysUserRepository extends JpaRepository<SysUser, Long> {
    SysUser findByUsername(String username);
}
