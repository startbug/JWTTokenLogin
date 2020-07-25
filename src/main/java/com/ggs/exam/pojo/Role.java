package com.ggs.exam.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;

public class Role implements GrantedAuthority {
    private Integer id;

    private String roleName;

    private String roleDesc;

    public Role(){}

    public Role(String authority) {
        this.roleName=authority;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc == null ? null : roleDesc.trim();
    }

    @JsonIgnore
    @Override
    public String getAuthority() {
        return roleName;
    }
}