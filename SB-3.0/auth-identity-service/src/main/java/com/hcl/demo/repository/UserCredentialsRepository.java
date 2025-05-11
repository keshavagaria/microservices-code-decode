package com.hcl.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hcl.demo.entity.UserCredentials;

public interface UserCredentialsRepository extends JpaRepository<UserCredentials, Integer>{

	Optional<UserCredentials> findByName(String username);

}
