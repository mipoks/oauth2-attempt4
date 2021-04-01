package com.example.demo.service;

import com.example.demo.dto.UserDto;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SignUpServiceImpl implements SignUpService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public long signUp(UserDto userDto) {

        User user = userRepository.save(User.builder()
                .email(userDto.getEmail())
                .name(userDto.getUsername())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .build());
        user = userRepository.save(user);
        return user.getId();
    }
}
