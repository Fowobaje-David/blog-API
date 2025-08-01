package com.example.blog_project.service;

import com.example.blog_project.dto.LoginRequest;
import com.example.blog_project.model.User;

public interface UserService {

    //REGISTER/CREATE
    User registerUser(User user);

    //LOGIN
//    String loginUser(Long userid, User user);

    String loginUser(LoginRequest user);
}
