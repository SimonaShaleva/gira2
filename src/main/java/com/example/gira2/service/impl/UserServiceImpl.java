package com.example.gira2.service.impl;

import com.example.gira2.model.entity.User;
import com.example.gira2.model.service.UserServiceModel;
import com.example.gira2.repository.UserRepository;
import com.example.gira2.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void registerUser(UserServiceModel userServiceModel) {
        userRepository.save(modelMapper.map(userServiceModel, User.class));
    }

    @Override
    public UserServiceModel findById(Long id) {
        return modelMapper.map(userRepository.findById(id).orElse(null), UserServiceModel.class);
    }

    @Override
    public UserServiceModel findByEmailAndPassword(String email, String password) {
       return userRepository.findByEmailAndPassword(email,password)
        .map(user -> modelMapper.map(user, UserServiceModel.class)).orElse(null);

    }

}
