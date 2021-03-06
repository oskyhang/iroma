package com.hanggle.frames.shiro;

import com.hanggle.frames.util.AccountValidatorUtil;
import com.oskyhang.system.entity.SysPermission;
import com.oskyhang.system.entity.SysRole;
import com.oskyhang.system.entity.SysUser;
import com.oskyhang.system.service.BdUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * @description:
 * @author: hanggle
 * @date: 2019/1/15
 */
@Slf4j
@Service
public class ShiroService {

    @Autowired
    private BdUserService bdUserService;

    public SysUser getUserInfoByUsername(String username){
        log.debug("ShiroService[]getUserInfoByUsername, username:{}" + username);
        // 手机号
        if (AccountValidatorUtil.isMobile(username)) {
            return bdUserService.getUserInfo(username, "tel");
        }

        // 邮箱
        if (AccountValidatorUtil.isEmail(username)) {
            return bdUserService.getUserInfo(username, "email");
        }
        // 用户名
        return bdUserService.getUserInfo(username, "username");
    }

    public List<SysRole> selectRoleByUser(String username){
        log.debug("ShiroService[]selectRoleByUser, username:{}", username);
        SysPermission sysPermission = new SysPermission();
        sysPermission.setUrl("/api/user/user/info");

        SysRole bdRole = new SysRole();
        bdRole.setRole("admin");

        return Collections.singletonList(bdRole);
    }

    public List<SysPermission> selectPermission(List<Long> roleIds){
        log.debug("ShiroService[]selectPermission, roleIds:{}", roleIds);
        SysPermission sysPermission = new SysPermission();
        sysPermission.setUrl("1qweqw");

        return Collections.singletonList(sysPermission);
    }
}
