package com.pictu.iam.service;

import com.pictu.iam.entity.UserCredential;
import com.pictu.iam.repositories.UserCredentialRepository;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserCredentialRepository userCredentialRepository;

    @Override
    public UserDetails loadUserByUsername(String phone) throws UsernameNotFoundException {
        UserCredential user = userCredentialRepository.findByPhone(phone)
            .orElseThrow(() -> new UsernameNotFoundException("User not found with phone: " + phone));

        return new org.springframework.security.core.userdetails.User(
            user.getPhone(), 
            "", // No password for now, can be updated to handle passwords
            new ArrayList<>() // Empty authorities for now, can be updated to handle roles
        );
    }
}
