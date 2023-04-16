package com.lm.blog.server.service.impl;

import com.google.common.base.Preconditions;
import com.lm.blog.server.mapper.UserMapper;
import com.lm.blog.server.model.UserDO;
import com.lm.blog.server.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
 * @Author Administrator
 * @Description 用户service接口实现
 * @Date 2023/1/20
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public UserDO getByEmail(String email) {
        // 参数异常校验,防止查询数据库异常
        Preconditions.checkArgument(StringUtils.isNotBlank(email),"邮箱不能为空");
        // userMapper层查询数据库
        return userMapper.getByEmail(email);
    }

    @Override
    public UserDO getByMobile(String mobile) {
        Preconditions.checkArgument(StringUtils.isNotBlank(mobile),"手机不能为空");

        return userMapper.getByMobile(mobile);
    }

    @Override
    public List<UserDO> listAll() {
        return userMapper.listAll();
    }

    @Override
    public List<UserDO> listByEmailLike(String email) {
        if (StringUtils.isBlank(email)) {
            return Collections.emptyList();
        }
        return userMapper.listByEmailLike(email);
    }

}
