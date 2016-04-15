package com.wbl.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.SpringProperties;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.wbl.config.ApplicationConfig;
import com.wbl.form.RegistrationForm;
import com.wbl.model.RoleModel;
import com.wbl.model.UserModel;
import com.wbl.repository.UserRepository;
import com.wbl.service.EmailService;
import com.wbl.service.UserService;
import com.wbl.util.AppConstants;

@Service
public class UserServiceImpl implements UserService {
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	private final EmailService emailService;
	private final ApplicationConfig appConfig;
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, EmailService emailService,
			ApplicationConfig appConfig) {
		if (userRepository == null) {
			throw new IllegalArgumentException("userRepository cannot be null");
		}
		if (passwordEncoder == null) {
			throw new IllegalArgumentException("passwordEncoder cannot be null");
		}
		if (emailService == null) {
			throw new IllegalArgumentException("emailService cannot be null");
		}
		if (appConfig == null) {
			throw new IllegalArgumentException("appConfig cannot be null");
		}
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
		this.emailService = emailService;
		this.appConfig = appConfig;
	}

	public UserModel registerUser(RegistrationForm registrationForm) {
		logger.debug("Register user starts");
		UserModel user = new UserModel();
		user.setName(registrationForm.getName());
		user.setEmail(registrationForm.getEmail().toLowerCase());
		user.setUsername(registrationForm.getEmail().toLowerCase());
		user.setContact(registrationForm.getContact());
		String password = RandomStringUtils.randomAlphanumeric(9);
		logger.debug(password);
		user.setPassword(passwordEncoder.encode(password));
		user.getRoles().add(new RoleModel(AppConstants.ROLE_USER));
		user.setAccountNonExpired(Boolean.TRUE);
		user.setAccountNonLocked(Boolean.TRUE);
		user.setCredentialsNonExpired(Boolean.TRUE);
		user.setEnabled(Boolean.TRUE);
		user = userRepository.save(user);
		logger.debug(appConfig.get("email.subject.USER_REGISTRATION"));

		logger.debug(SpringProperties.getProperty("email.subject.USER_REGISTRATION"));

		// Sending mail
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("name", registrationForm.getName());
		params.put("password", password);
		params.put("username", registrationForm.getEmail().toLowerCase());
		params.put(AppConstants.EMAIL.FROM, AppConstants.EMAIL_FROM);
		params.put(AppConstants.EMAIL.TEMPLATE, AppConstants.EMAIL.USER_REGISTRATION_TEMPLATE);
		params.put(AppConstants.EMAIL.TO, new String[] { registrationForm.getEmail() });
		params.put(AppConstants.EMAIL.SUBJECT,
				appConfig.get(AppConstants.EMAIL.SUBJECT_PREFIX + AppConstants.EMAIL.USER_REGISTRATION_TEMPLATE));
		emailService.sendEmail(params);
		logger.debug("Register user completes");
		return user;
	}

	public Boolean emailExists(String email) {
		UserModel user = userRepository.findByEmail(email);
		if (user == null)
			return Boolean.FALSE;
		else
			return Boolean.TRUE;
	}

	public UserModel findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

}
