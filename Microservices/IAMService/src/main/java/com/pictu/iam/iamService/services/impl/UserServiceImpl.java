package com.pictu.iam.iamService.services.impl;

import com.pictu.core.exceptions.ResourceNotFoundException;
import com.pictu.core.utilities.IdGeneratorString;
import com.pictu.iam.iamService.entities.User;
import com.pictu.iam.iamService.repositories.UserRepository;
import com.pictu.iam.iamService.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {

        user.setUserId(IdGeneratorString.userIDGenerator());

        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getSingleUser(String userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + userId));
    }
}

