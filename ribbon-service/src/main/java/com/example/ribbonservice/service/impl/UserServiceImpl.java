package com.example.ribbonservice.service.impl;

import com.example.ribbonservice.entity.po.User;
import com.example.ribbonservice.mapper.UserMapper;
import com.example.ribbonservice.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author aaron
 * @since 2020-12-20
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
