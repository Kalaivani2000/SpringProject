package com.springsecuritypractice.SpringMVCSecurity.controller;

import com.springsecuritypractice.SpringMVCSecurity.dto.UserDto;
import com.springsecuritypractice.SpringMVCSecurity.model.User;
import com.springsecuritypractice.SpringMVCSecurity.repository.UserRepository;
import com.springsecuritypractice.SpringMVCSecurity.service.CustomSuccessHandler;
import com.springsecuritypractice.SpringMVCSecurity.service.CustomUserDetail;
import com.springsecuritypractice.SpringMVCSecurity.service.CustomUserDetailService;
import com.springsecuritypractice.SpringMVCSecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private CustomUserDetailService customUserDetailService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDetailsService userDetailsService;


    @GetMapping("/registration")
    public String getRegistrationPage(@ModelAttribute("user")UserDto userDto){

        return "registration";
    }

    @PostMapping("/registration")
    public String saveUser(@ModelAttribute("user")UserDto userDto,Model model){
        userService.save(userDto);
        model.addAttribute("message","Registered Successfully");
        return "registration";
    }

    @GetMapping("/login")
    public String getLoginPage(){

        return "login";
    }


    @PostMapping("/login")
    public String loginSuccess(Model model, Principal principal) {
        if (principal != null) {
            String username = principal.getName();
            // Your login logic here

            // Redirect to the user-page
            return "login";
        }

        // Handle the case when principal is null, maybe redirect to an error page
        return "login-error";
    }


    @GetMapping("/home")
    public String homePage(){
        return "home";
    }
}
