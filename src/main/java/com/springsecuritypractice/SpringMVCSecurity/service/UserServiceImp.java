package com.springsecuritypractice.SpringMVCSecurity.service;

import com.springsecuritypractice.SpringMVCSecurity.dto.UserDto;
import com.springsecuritypractice.SpringMVCSecurity.model.User;
import com.springsecuritypractice.SpringMVCSecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;


    @Override
    public User save(UserDto userDto) {
        User user = new User(userDto.getFullname(),userDto.getEmail(),
                (passwordEncoder.encode(userDto.getPassword())),userDto.getRole());
        return userRepository.save(user);
    }


}
