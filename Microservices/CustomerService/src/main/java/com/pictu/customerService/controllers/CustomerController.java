package com.pictu.customerService.controllers;

import com.pictu.customerService.entities.Customer;
import com.pictu.customerService.services.CustomerService;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {


    @Autowired
    public CustomerService customerService;
    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
        Customer savedCustomer = customerService.saveCustomer(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCustomer);
    }
    // Get a single Customer

    int retryCount =1;

    @GetMapping("/{customerId}")
    //@CircuitBreaker(name="photoBreaker", fallbackMethod = "photoFallback")
    //@Retry(name="photoService", fallbackMethod = "photoFallback")
    @RateLimiter(name = "customerRateLimiter", fallbackMethod = "photoFallback")
    public ResponseEntity<Customer> getSingleCustomer(@PathVariable String customerId){
        System.out.println("Retry count "+ retryCount);
        retryCount++;
        Customer customer = customerService.getSingleCustomer(customerId);
        return ResponseEntity.ok(customer);
    }

    //Creating fallback method for circuit breaker

    //Lets take an integer to keep the count of retries


    public ResponseEntity<Customer> photoFallback(String customerId, Exception ex){
    //    System.out.println("Fallback is executed==============Service Down "+ex.getMessage());
        Customer customer = Customer.builder().email("dummy@gmail.com").name("Dummy").password("asdfasdf").build();
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }



    //Get All Customers
    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers(){
        List<Customer> allCustomers = customerService.getAllCustomers();
        return ResponseEntity.ok(allCustomers);
    }
}
