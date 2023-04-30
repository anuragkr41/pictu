package com.pictu.iam.iamService.repositories;

import com.pictu.iam.iamService.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    // If you want to implement any custom method or query then you can write here

}
