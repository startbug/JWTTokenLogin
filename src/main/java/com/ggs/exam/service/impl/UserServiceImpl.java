package com.ggs.exam.service.impl;

import com.ggs.exam.common.RoleEnum;
import com.ggs.exam.mapper.RoleMapper;
import com.ggs.exam.mapper.UserMapper;
import com.ggs.exam.pojo.Role;
import com.ggs.exam.pojo.User;
import com.ggs.exam.pojo.UserExample;
import com.ggs.exam.pojo.vo.UserVO;
import com.ggs.exam.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

/**
 *
 *  @author: Starbug
 *  @date: 2020-07-02 18:28
 */
@Transactional(propagation = Propagation.REQUIRED,readOnly = true)
@Service
public class UserServiceImpl implements UserService {

    @Autowired(required = false)
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserExample example = new UserExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<User> userList = userMapper.selectByExample(example);

        User user = null;
        if (null != userList && userList.size() > 0) {
            user = userList.get(0);
        }
//        Assert.notNull(user, "用户名或密码错误,请重新输入");
        if (user == null) {
            throw new UsernameNotFoundException("用户名或密码错误,请重新输入");
        }

        List<Role> role=roleMapper.selectRoleWithUserId(user.getId());

        if(role==null){
            throw  new RoleNotFoundException("用户授权失败,请通知管理员!");
        }
        user.setRoleList(role);

        return user;
    }

    @Transactional(propagation = Propagation.REQUIRED,readOnly = false)
    @Override
    public void registerUser(UserVO userVO) {
        User user = new User();

        BeanUtils.copyProperties(userVO,user);

        UserExample userExample=new UserExample();
        userExample.createCriteria().andUsernameEqualTo(user.getUsername());
        List<User> users = userMapper.selectByExample(userExample);

        Assert.isTrue(!(null!=users&&users.size()>0),"用户名已存在,请更换!");

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        int userCount = userMapper.insert(user);
//        count=0;
        Assert.isTrue(userCount>0,"注册失败,请重新注册!");

        int roleCount=roleMapper.insertUserRole(user.getId(), RoleEnum.USER.ROLE_NUM);

        Assert.isTrue(roleCount>0,"授权失败,请重新注册!");
    }

    public class RoleNotFoundException extends AuthenticationException{

        public RoleNotFoundException(String msg) {
            super(msg);
        }
    }
}
