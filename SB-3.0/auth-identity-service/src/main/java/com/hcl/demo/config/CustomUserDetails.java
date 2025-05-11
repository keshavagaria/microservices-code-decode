package com.hcl.demo.config;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.hcl.demo.entity.UserCredentials;

public class CustomUserDetails implements UserDetails{

	private String username;
	private String password;
	
	
	public CustomUserDetails(UserCredentials credentials) {
		this.username = credentials.getName();
		this.password = credentials.getPassword();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

}
