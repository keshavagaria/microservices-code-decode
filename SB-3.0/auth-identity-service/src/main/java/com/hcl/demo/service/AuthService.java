package com.hcl.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.hcl.demo.entity.UserCredentials;
import com.hcl.demo.repository.UserCredentialsRepository;

@Service
public class AuthService {

	@Autowired
	private UserCredentialsRepository credentialsRepository;
	@Autowired
	private PasswordEncoder encoder;
	@Autowired
	private JwtService jwtService;
	
	public String saveUser(UserCredentials credentials) {
		credentials.setPassword(encoder.encode(credentials.getPassword()));
		credentialsRepository.save(credentials);
		return "User Added to the System";
	}
	
	public String generateToken(String username) {
		
		return jwtService.generateToken(username);
	}
	
	public void validateToken(String token) {
		
	 jwtService.validateToken(token);
	}
	
}
