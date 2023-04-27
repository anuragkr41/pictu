package com.pictu.iam.iamService.repositories;

import com.pictu.iam.iamService.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {
    // If you want to implement any custom method or query then you can write here

}
