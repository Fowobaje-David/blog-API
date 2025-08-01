package com.example.blog_project.service_implementation;

import com.example.blog_project.dto.LoginRequest;
import com.example.blog_project.exception.HandleEventDoesNotExistException;
import com.example.blog_project.model.User;
import com.example.blog_project.repository.UserRepository;
import com.example.blog_project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User registerUser(User User) {
        User newUser = new User();
        newUser.setUserid(User.getUserid());
        newUser.setUsername(User.getUsername());
        newUser.setPassword(User.getPassword());
        newUser.setEmail(User.getEmail());
        newUser.setPhonenumber(User.getPhonenumber());

        userRepository.save(newUser);
        return newUser;
    }

    @Override
    public String loginUser(LoginRequest user) {
        User existing = userRepository.findByEmailIgnoreCase(String.valueOf(user.getEmail()))
                .orElseThrow(() -> new HandleEventDoesNotExistException("User details not found"));

        if(!existing.getPassword().equals(user.getPassword())){
            throw new RuntimeException("Password Invalid");
        }

        return "logged in Successfully";
    }
}
