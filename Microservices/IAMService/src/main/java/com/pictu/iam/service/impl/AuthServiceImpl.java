package com.pictu.iam.service.impl;

import com.pictu.iam.entity.Role;
import com.pictu.iam.entity.UserCredential;
import com.pictu.iam.repositories.RoleRepository;
import com.pictu.iam.repositories.UserCredentialRepository;
import com.pictu.iam.service.AuthService;
import com.pictu.iam.service.SmsService;
import com.pictu.iam.util.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	private UserCredentialRepository userCredentialRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private SmsService smsService;

	@Value("${otp.fixedForTesting}")
	private boolean fixedOtpForTesting;

	@Override
	public UserCredential registerUser(String phone, Role.RoleName roleName) {
		UserCredential user = new UserCredential();
		user.setPhone(phone);

		Set<Role> roles = new HashSet<>();
		Role userRole = roleRepository.findByName(roleName).orElseThrow(() -> new RuntimeException("Role not found."));
		roles.add(userRole);
		user.setRoles(roles);

		return userCredentialRepository.save(user);
	}

	@Override
	public String generateOtp(String phone) {
		UserCredential user = userCredentialRepository.findByPhone(phone)
				.orElseThrow(() -> new RuntimeException("User not found."));

		String otp;
		if (fixedOtpForTesting) {
			otp = "123456";
		} else {
			otp = generateRandomOtp();
		}

		user.setOTP(otp);
		userCredentialRepository.save(user);

		if (!fixedOtpForTesting) {
			// Send OTP via SMS
			smsService.sendOtp(phone, otp);
		}
		return otp;
	}

	@Override
	public String issueJwt(UserDetails userDetails) {
		String jwt = jwtUtil.generateToken(userDetails);
	    System.out.println("Generated JWT Token: " + jwt); // This is to be hide later
	    
	    return jwt;
		//return jwtUtil.generateToken(userDetails);
	}

	@Override
	public boolean validateOtp(String phone, String otp) {
		UserCredential user = userCredentialRepository.findByPhone(phone)
				.orElseThrow(() -> new RuntimeException("User not found."));

		if (otp.equals(user.getOTP())) {
			// OTP is valid, you can proceed with authentication
			return true;
		} else {
			return false;
		}
	}

	private String generateRandomOtp() {
		Random random = new Random();
		 return String.format("%06d", random.nextInt(999999));
		//return "123456"; // The above line should be uncommented when trying to actually generate random
							// 6 digit OPT
	}
}