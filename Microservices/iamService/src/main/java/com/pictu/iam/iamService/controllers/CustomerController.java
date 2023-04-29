package com.pictu.iam.iamService.controllers;

import com.pictu.iam.iamService.entities.users.Customer;
import com.pictu.iam.iamService.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
        Customer savedCustomer = customerService.saveCustomer(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCustomer);
    }


    // Get a single Customer

    @GetMapping("/{customerId}")
    public ResponseEntity<Customer> getSingleCustomer(@PathVariable String customerId){
        Customer customer = customerService.getSingleCustomer(customerId);
        return ResponseEntity.ok(customer);
    }

    //Get All Customers
    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers(){
        List<Customer> allCustomers = customerService.getAllCustomers();
        return ResponseEntity.ok(allCustomers);
    }

}
