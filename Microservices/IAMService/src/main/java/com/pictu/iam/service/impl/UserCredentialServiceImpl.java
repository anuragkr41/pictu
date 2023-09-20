package com.pictu.iam.service.impl;

import com.pictu.iam.entity.UserCredential;
import com.pictu.iam.repositories.UserCredentialRepository;
import com.pictu.iam.service.UserCredentialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserCredentialServiceImpl implements UserCredentialService {

    @Autowired
    private UserCredentialRepository userCredentialRepository;

    @Override
    public String saveUser(UserCredential userCredential) {
        return null;
    }
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//    @Override
//    public String saveUser(UserCredential userCredential) {
//
//        userCredential.setPassword(passwordEncoder.encode(userCredential.getPassword()));
//
//
//        userCredentialRepository.save(userCredential);
//        return "User Added to the system";
//    }
}
