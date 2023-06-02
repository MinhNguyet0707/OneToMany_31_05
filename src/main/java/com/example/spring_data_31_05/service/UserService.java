package com.example.spring_data_31_05.service;


import com.example.spring_data_31_05.entity.User;
import com.example.spring_data_31_05.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUser() {
        return userRepository.findAll();
    }
}
