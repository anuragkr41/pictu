package com.pictu.iam.iamService.controllers;
import com.pictu.iam.iamService.entities.User;
import com.pictu.iam.iamService.services.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/users")
public class UserController {


    @Autowired
    public UserService userService;
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User savedUser = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }
    // Get a single User

    int retryCount =1;

    @GetMapping("/{userId}")
    //@CircuitBreaker(name="photoBreaker", fallbackMethod = "photoFallback")
    //@Retry(name="photoService", fallbackMethod = "photoFallback")
    @RateLimiter(name = "userRateLimiter", fallbackMethod = "photoFallback")
    public ResponseEntity<User> getSingleUser(@PathVariable String userId){
        System.out.println("Retry count "+ retryCount);
        retryCount++;
        User user = userService.getSingleUser(userId);
        return ResponseEntity.ok(user);
    }

    //Creating fallback method for circuit breaker

    //Lets take an integer to keep the count of retries


    public ResponseEntity<User> photoFallback(String userId, Exception ex){
    //    System.out.println("Fallback is executed==============Service Down "+ex.getMessage());
        User user = User.builder().email("dummy@gmail.com").name("Dummy").password("asdfasdf").build();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }



    //Get All Users
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> allUsers = userService.getAllUsers();
        return ResponseEntity.ok(allUsers);
    }
}
