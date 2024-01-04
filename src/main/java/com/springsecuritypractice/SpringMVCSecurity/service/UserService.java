package com.springsecuritypractice.SpringMVCSecurity.service;

import com.springsecuritypractice.SpringMVCSecurity.dto.UserDto;
import com.springsecuritypractice.SpringMVCSecurity.model.User;


public interface UserService {

  User save(UserDto userDto);


}
