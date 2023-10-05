package com.pictu.iam.repositories;

import com.pictu.iam.entity.UserCredential;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCredentialRepository extends JpaRepository<UserCredential, Integer> {
	Optional<UserCredential> findByPhone(String phone);
}
