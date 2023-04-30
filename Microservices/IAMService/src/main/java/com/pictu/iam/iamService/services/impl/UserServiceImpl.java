package com.pictu.iam.iamService.services.impl;

import com.pictu.core.exceptions.ResourceNotFoundException;
import com.pictu.core.utilities.IdGeneratorString;
import com.pictu.iam.iamService.entities.Photo;
import com.pictu.iam.iamService.entities.User;
import com.pictu.iam.iamService.repositories.UserRepository;
import com.pictu.iam.iamService.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

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

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + userId));

        //Get Photos of the above user from Photo Service
        ArrayList<Photo> photosOfUser = restTemplate.getForObject("http://PHOTO-SERVICE/photos/user/"+ user.getUserId(), ArrayList.class);

        user.setPhotos(photosOfUser);
        //logger.info("{}", forObject);
        return user;




    }
}

