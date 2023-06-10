package com.pictu.customerService.repositories;

import com.pictu.customerService.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {
    // If you want to implement any custom method or query then you can write here

}
