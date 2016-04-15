package com.wbl.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wbl.model.UserModel;
import com.wbl.service.UserService;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserService userService;

	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserModel user = userService.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("Invalid username/password.");
		}

		return user;
	}

}
