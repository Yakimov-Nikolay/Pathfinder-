package com.example.pathfinder.service;

import com.example.pathfinder.model.entity.User;
import com.example.pathfinder.model.service.UserServiceModel;

public interface UserService {

    void registerUser(UserServiceModel map);

    UserServiceModel findById(Long id);

    User findByUsername(String name);
}
