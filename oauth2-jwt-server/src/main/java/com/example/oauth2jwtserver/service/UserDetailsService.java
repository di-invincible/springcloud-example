package com.example.oauth2jwtserver.service;

import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author aaron
 * @since 2021-01-04
 */
public interface UserDetailsService {
    void initData();

    UserDetails loadUserByUsername(String username);
}
