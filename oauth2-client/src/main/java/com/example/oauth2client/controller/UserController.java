package com.example.oauth2client.controller;

import com.example.oauth2client.util.OkHttpUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author aaron
 * @since 2021-01-07
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Value("${github.client_id}")
    private String clientId;

    @Value("${github.client_secret}")
    private String clientSecret;

    @GetMapping("/getCurrentUser")
    public Object getCurrentUser(Authentication authentication) {
        return authentication;
    }

    @GetMapping("/callback/{code}")
    public String getCallBack(@PathVariable("code") String code){
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
