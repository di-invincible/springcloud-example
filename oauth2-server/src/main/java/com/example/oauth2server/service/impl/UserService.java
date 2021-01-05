package com.example.oauth2server.service.impl;

import com.example.oauth2server.entity.po.User;
import com.example.oauth2server.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author aaron
 * @since 2021-01-04
 */
public class UserService implements UserDetailsService {
    private List<User> userList;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void initData() {
        String password = passwordEncoder.encode("123456");
        userList = new ArrayList<>();
        userList.add(new User().setNickname("macro").setPassword(password).setAuthorities(AuthorityUtils.commaSeparatedStringToAuthorityList("client")));
        userList.add(new User().setNickname("andy").setPassword(password).setAuthorities(AuthorityUtils.commaSeparatedStringToAuthorityList("andy")));
        userList.add(new User().setNickname("mark").setPassword(password).setAuthorities(AuthorityUtils.commaSeparatedStringToAuthorityList("mark")));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<User> findUserList = userList.stream().filter(user -> user.getUsername().equals(username)).collect(Collectors.toList());
        if (!CollectionUtils.isEmpty(findUserList)) {
            return (UserDetails)findUserList.get(0);
        } else {
            throw new UsernameNotFoundException("用户名或密码错误");
        }
    }
}
