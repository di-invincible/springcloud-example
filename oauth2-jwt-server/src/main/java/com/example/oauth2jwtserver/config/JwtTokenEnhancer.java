package com.example.oauth2jwtserver.config;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.HashMap;
import java.util.Map;

/**
 * Jwt内容增强器
 * @author aaron
 * @since 2021-01-07
 */
public class JwtTokenEnhancer implements TokenEnhancer {
    /**
     * Provides an opportunity for customization of an access token (e.g. through its additional information map) during
     * the process of creating a new token for use by a client.
     *
     * @param accessToken    the current access token with its expiration and refresh token
     * @param authentication the current authentication including client and user details
     * @return a new token enhanced with additional information
     */
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        Map<String, Object> info = new HashMap<>(16);
        info.put("enhance", "enhance info");
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
        return accessToken;
    }
}
