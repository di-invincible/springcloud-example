package com.example.hystrixservice.service;

import com.example.common.result.CommonResult;
import com.example.hystrixservice.po.User;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.Future;

/**
 * @author aaron
 * @since 2020-12-20
 */
public interface UserService {

    CommonResult getUser(Long id);

    CommonResult getDefaultUser(Long id);

    CommonResult getUserCommand( Long id);

    CommonResult getUserException(Long id);

    CommonResult getUserCache(Long id);

    CommonResult removeCache(Long id);

    Future<User> getUserFuture(Long id);
}
