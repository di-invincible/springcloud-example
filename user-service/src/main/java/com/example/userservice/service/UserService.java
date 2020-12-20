package com.example.userservice.service;

import com.example.userservice.entity.po.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author aaron
 * @since 2020-12-20
 */
public interface UserService extends IService<User> {

    /**
     * 创建
     * @param user
     */
    void create(User user);

    /**
     * 获取
     * @param id
     * @return
     */
    User getUser(Long id);

    /**
     * 批量获取
     * @param ids
     * @return
     */
    List<User> getUserByIds(List<Long> ids);

    User getByUsername(String username);

    void update(User user);

    void delete(Long id);
}
