package com.example.gira2.service;

import com.example.gira2.model.service.UserServiceModel;

public interface UserService {
    UserServiceModel findByEmailAndPassword(String email, String password);

    void registerUser(UserServiceModel userServiceModel);

    UserServiceModel findById(Long id);
}
