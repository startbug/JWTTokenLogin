package com.ggs.exam.service;

import com.ggs.exam.pojo.User;
import com.ggs.exam.pojo.vo.UserVO;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 *  @author: Starbug
 *  @date: 2020-07-02 18:28
 */
public interface UserService extends UserDetailsService {
    void registerUser(UserVO userVO);
}
