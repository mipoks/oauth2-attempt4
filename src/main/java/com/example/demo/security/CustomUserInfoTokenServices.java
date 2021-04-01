package com.example.demo.security;

import com.example.demo.repository.UserRepository;
import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoTokenServices;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.security.oauth2.provider.OAuth2Authentication;

public class CustomUserInfoTokenServices extends UserInfoTokenServices {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public CustomUserInfoTokenServices(String userInfoEndpointUrl, String clientId) {
        super(userInfoEndpointUrl, clientId);
    }

    @Override
    public OAuth2Authentication loadAuthentication(String accessToken) throws AuthenticationException, InvalidTokenException {
        System.out.println("TROLOLO " + accessToken);
        return super.loadAuthentication(accessToken);
    }
}
