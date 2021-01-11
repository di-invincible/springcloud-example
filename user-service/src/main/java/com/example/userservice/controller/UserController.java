package com.example.userservice.controller;


import com.example.common.result.CommonResult;
import com.example.userservice.entity.po.User;
import com.example.userservice.service.UserService;
import com.example.userservice.util.OkHttpUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author aaron
 * @since 2020-12-20
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Value("${github.client_id}")
    private String clientId;

    @Value("${github.client_secret}")
    private String clientSecret;

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public CommonResult<Boolean> create(@RequestBody User user) {
        userService.create(user);
        return CommonResult.success();
    }

    @GetMapping("/{id}")
    public CommonResult<User> getUser(@PathVariable Long id) {
        User user = userService.getUser(id);
        log.info("根据id获取用户信息，用户名称为：{}",user.getUsername());
        return CommonResult.success(user);
    }

    @GetMapping("/getUserByIds")
    public CommonResult<List<User>> getUserByIds(@RequestParam List<Long> ids) {
        List<User> userList= userService.getUserByIds(ids);
        log.info("根据ids获取用户信息，用户列表为：{}",userList);
        return CommonResult.success(userList);
    }

    @GetMapping("/getByUsername")
    public CommonResult<User> getByUsername(@RequestParam String username) {
        User user = userService.getByUsername(username);
        return CommonResult.success(user);
    }

    @PostMapping("/update")
    public CommonResult<Boolean> update(@RequestBody User user) {
        userService.update(user);
        return CommonResult.success();
    }

    @PostMapping("/delete/{id}")
    public CommonResult<Boolean> delete(@PathVariable Long id) {
        userService.delete(id);
        return CommonResult.success();
    }


    @GetMapping("/callback")
    public String getCallBack(@RequestParam("code") String code){
        String url = "https://github.com/login/oauth/access_token?client_id="+clientId+"&client_secret="+clientSecret+"&code=";
        url = url+code;
        try {
            return OkHttpUtil.getSynchronized(url);
        } catch (IOException e) {
            e.printStackTrace();
            return "失败";
        }
    }
}
