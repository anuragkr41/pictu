package com.pictu.iam.iamService.services.impl;

import com.pictu.core.exceptions.ResourceNotFoundException;
import com.pictu.iam.iamService.entities.users.Customer;
import com.pictu.iam.iamService.repositories.CustomerRepository;
import com.pictu.iam.iamService.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer saveCustomer(Customer customer) {

        String randomCustomerId = UUID.randomUUID().toString();
        customer.setCustomerId(randomCustomerId);

        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getSingleCustomer(String customerId) {
        return customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + customerId));
    }
}

