package com.hcl.demo.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.hcl.demo.entity.UserCredentials;
import com.hcl.demo.repository.UserCredentialsRepository;

public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserCredentialsRepository credentialsRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserCredentials> credential =   credentialsRepository.findByName(username);
		return credential.map(CustomUserDetails::new)
				.orElseThrow(()->new UsernameNotFoundException("user not found with name "+username));
	}

}
