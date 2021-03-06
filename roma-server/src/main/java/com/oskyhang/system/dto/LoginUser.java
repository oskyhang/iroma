package com.oskyhang.system.dto;

import com.oskyhang.system.entity.SysUser;
import lombok.Data;

/**
 * @Description: <br/>
 * @Author: zh <br/>
 * @Date: 2018/11/4 <br/>
 */
@Data
public class LoginUser {
    private Long userId;
    private String token;
    private Long personId;
    private String personName;
    private Integer gender;

    public LoginUser() {
    }

    public LoginUser(SysUser sysUser) {
        this.userId = sysUser.getId();
    }
}
