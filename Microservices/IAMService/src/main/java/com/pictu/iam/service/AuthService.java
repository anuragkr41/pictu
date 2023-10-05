package com.pictu.iam.service;

import org.springframework.security.core.userdetails.UserDetails;

import com.pictu.iam.entity.Role;
import com.pictu.iam.entity.UserCredential;

public interface AuthService {
    UserCredential registerUser(String phone, Role.RoleName roleName);
    String generateOtp(String phone);
    boolean validateOtp(String phone, String otp);
    String issueJwt(UserDetails userDetails);
}
