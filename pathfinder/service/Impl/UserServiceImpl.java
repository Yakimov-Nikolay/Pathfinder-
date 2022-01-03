package com.example.pathfinder.service.Impl;

import com.example.pathfinder.model.entity.User;
import com.example.pathfinder.model.entity.enums.LevelEnums;
import com.example.pathfinder.model.service.UserServiceModel;
import com.example.pathfinder.repository.UserRepository;
import com.example.pathfinder.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper  modelMapper;
    private final PasswordEncoder passwordEncoder;


    public UserServiceImpl(UserRepository userRepository,
                           ModelMapper modelMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void registerUser(UserServiceModel userServiceModel) {

        User user = modelMapper.map(userServiceModel, User.class);
        user.setLevel(LevelEnums.BEGINNER);
        user.setPassword(passwordEncoder.encode(userServiceModel.getPassword()));

        userRepository.save(user);

    }
    @Override
    public UserServiceModel findById(Long id) {
        return userRepository.findById(id)
                .map(user -> modelMapper.map(user, UserServiceModel.class))
                .orElse(null);
    }

    @Override
    public User findByUsername(String name) {
        return userRepository.findByUsername(name).orElse(null);
    }

}
