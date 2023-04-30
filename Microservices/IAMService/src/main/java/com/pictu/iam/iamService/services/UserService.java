package com.pictu.iam.iamService.services;

import com.pictu.iam.iamService.entities.User;

import java.util.List;

public interface UserService {

    //Create User
    User saveUser(User user);

    //Get all User
    List<User> getAllUsers();

    User getSingleUser(String userId);

    //ToDo: Delete

    //Todo: Update

}
