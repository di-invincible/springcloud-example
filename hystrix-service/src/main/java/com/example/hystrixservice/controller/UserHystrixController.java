package com.example.hystrixservice.controller;

import cn.hutool.core.thread.ThreadUtil;
import com.example.common.result.CommonResult;
import com.example.hystrixservice.po.User;
import com.example.hystrixservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * 服务熔断测试接口
 * @author wd
 * @since 2020-12-20
 */
@RestController
@RequestMapping("/user")
public class UserHystrixController {

    @Autowired
    private UserService userService;

    /**
     * 服务降级
     * @param id 用户id
     * @return CommonResult
     */
    @GetMapping("/testFallback/{id}")
    public CommonResult testFallback(@PathVariable Long id) {
        return userService.getUser(id);
    }

    /**
     * 设置命令、分组及线程池名称
     * @param id 用户id
     * @return CommonResult
     */
    @GetMapping("/testCommand/{id}")
    public CommonResult testCommand(@PathVariable Long id) {
        return userService.getUserCommand(id);
    }

    /**
     * 使用ignoreExceptions忽略某些异常降级
     * @param id 用户id
     * @return CommonResult
     */
    @GetMapping("/testException/{id}")
    public CommonResult testException(@PathVariable Long id) {
        return userService.getUserException(id);
    }

    /**
     * 测试使用缓存
     * @param id 用户id
     * @return CommonResult
     */
    @GetMapping("/testCache/{id}")
    public CommonResult testCache(@PathVariable Long id) {
        userService.getUserCache(id);
        userService.getUserCache(id);
        userService.getUserCache(id);
        return CommonResult.success();
    }

    /**
     * 测试移除缓存
     * @param id 用户id
     * @return CommonResult
     */
    @GetMapping("/testRemoveCache/{id}")
    public CommonResult testRemoveCache(@PathVariable Long id) {
        userService.getUserCache(id);
        userService.removeCache(id);
        userService.getUserCache(id);
        return CommonResult.success();
    }

    @GetMapping("/testCollapser")
    public CommonResult testCollapser() throws ExecutionException, InterruptedException {
        Future<User> future1 = userService.getUserFuture(1L);
        Future<User> future2 = userService.getUserFuture(2L);
        future1.get();
        future2.get();
        ThreadUtil.safeSleep(200);
//        Thread.sleep(200);
        Future<User> future3 = userService.getUserFuture(3L);
        future3.get();
        return CommonResult.success();
    }

}
