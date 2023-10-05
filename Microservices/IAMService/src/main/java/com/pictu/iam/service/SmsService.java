package com.pictu.iam.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.pictu.iam.dto.SmsRequest;

@Service
public class SmsService {

    public void sendOtp(String phone, String otp) {
        // Replace with your actual SMS gateway API
//        String smsApiUrl = "https://api.sms-gateway.com/send";
//        String apiKey = "your-api-key";
        // Later all these have to be configured in the properties file and to be 
        //accessed from there
        

        RestTemplate restTemplate = new RestTemplate();
        
        String message = "Your OTP is: " + otp;
        
        // Construct the API request payload
        // Note: This is hypothetical and will depend on your actual SMS gateway
//        SmsRequest smsRequest = new SmsRequest(apiKey, phone, message);
        
        // Uncomment the following line to send the actual request when you run this in your environment
         
//        restTemplate.postForEntity(smsApiUrl, smsRequest, String.class);
    }
}
