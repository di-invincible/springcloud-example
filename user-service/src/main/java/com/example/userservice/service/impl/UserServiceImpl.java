package com.example.userservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.userservice.entity.po.User;
import com.example.userservice.mapper.UserMapper;
import com.example.userservice.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author aaron
 * @since 2020-12-20
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    /**
     * 创建
     *
     * @param user
     */
    @Override
    public void create(User user) {
        save(user);
    }

    /**
     * 获取
     *
     * @param id
     * @return
     */
    @Override
    public User getUser(Long id) {
        return getById(id);
    }

    /**
     * 批量获取
     *
     * @param ids
     * @return
     */
    @Override
    public List<User> getUserByIds(List<Long> ids) {
        return listByIds(ids);
    }

    @Override
    public User getByUsername(String username) {
        return getOne(new QueryWrapper<User>().ge("username", username));
    }

    @Override
    public void update(User user) {
        updateById(user);
    }

    @Override
    public void delete(Long id) {
        removeById(id);
    }
}
