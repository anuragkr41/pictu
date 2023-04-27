package com.pictu.iam.iamService.services;

import com.pictu.iam.iamService.entities.Customer;

import java.util.List;

public interface CustomerService {

    //Create Customer
    Customer saveCustomer(Customer customer);

    //Get all Customer
    List<Customer> getAllCustomers();

    Customer getSingleCustomer(String customerId);

    //ToDo: Delete

    //Todo: Update

}
