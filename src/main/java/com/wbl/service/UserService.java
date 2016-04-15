package com.wbl.service;

import com.wbl.form.RegistrationForm;
import com.wbl.model.UserModel;

public interface UserService {

	public UserModel registerUser(RegistrationForm registrationForm);

	public Boolean emailExists(String email);

	public UserModel findByUsername(String username);

}
