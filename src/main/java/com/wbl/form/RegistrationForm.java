package com.wbl.form;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

public class RegistrationForm implements Serializable {

	/**
	 * Serial version uid
	 */
	private static final long serialVersionUID = 227549920242899597L;

	@NotNull
	@Size(min = 3)
	private String name;

	@NotNull
	@Email
	@Size(min = 5)
	private String email;

	@NotNull
	@Size(min = 10, max = 12)
	private String contact;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

}
