package com.pictu.iam.controller;

import com.pictu.iam.dto.JwtResponse;
import com.pictu.iam.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;
    
    @Autowired
    private UserDetailsService userDetailsService;

    @PostMapping("/generate-otp")
    public ResponseEntity<?> generateOtp(@RequestBody String phone) {
        String otp = authService.generateOtp(phone);
        // In production, you'd send this OTP via SMS and not return it in the response.
        return ResponseEntity.ok("OTP generated and sent to your phone");
    }

    @PostMapping("/validate-otp")
    public ResponseEntity<?> validateOtp(@RequestBody String phone, @RequestBody String otp) {
        boolean isValid = authService.validateOtp(phone, otp);
        if (isValid) {
            UserDetails userDetails = userDetailsService.loadUserByUsername(phone);
            String jwt = authService.issueJwt(userDetails);
            return ResponseEntity.ok(new JwtResponse(jwt));
        } else {
            return ResponseEntity.status(400).body("Invalid OTP");
        }
    }
   
}
