package com.ggs.exam.common;

import lombok.AllArgsConstructor;
import lombok.Getter;


/**
 *
 *  @author: Starbug
 *  @date: 2020-07-05 15:44
 */
public enum RoleEnum {

    USER(1,"ROLE_USER","普通用户"),
    ADMIN(2,"ROLE_ADMIN","管理元");

    public final int ROLE_NUM;
    public final String ROLE_NAME;
    public final String ROLE_DESC;

    private RoleEnum(int ROLE_NUM,String ROLE_NAME,String ROLE_DESC){
        this.ROLE_NAME=ROLE_NAME;
        this.ROLE_NUM=ROLE_NUM;
        this.ROLE_DESC=ROLE_DESC;
    }

}
