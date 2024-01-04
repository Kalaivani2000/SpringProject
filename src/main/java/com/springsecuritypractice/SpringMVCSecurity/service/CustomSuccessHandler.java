package com.springsecuritypractice.SpringMVCSecurity.service;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Service;
import java.io.IOException;

@Service
public class CustomSuccessHandler implements AuthenticationSuccessHandler {


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        var authourites=authentication.getAuthorities();

        var role=authourites.stream().map(r->r.getAuthority()).findFirst();

        if(role.orElse("").equals("ADMIN")) {
            response.sendRedirect("/admin-page");
        } else if (role.orElse("").equals("USER")){
            response.sendRedirect("/user-page");
        }
        else{
            response.sendRedirect("/error");
        }
    }
}

