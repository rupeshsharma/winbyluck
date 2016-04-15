package com.wbl.util;

public interface AppConstants {

	Long ROLE_ADMIN = 1l;
	Long ROLE_USER = 2l;
	String EMAIL_FROM = "noReply@winbyluck.com";
	String DELIMETER_EMAIL = "@";

	public interface EMAIL {
		String SUBJECT_PREFIX = "email.subject.";
		String ENCODING = "UTF-8";
		String TEMPLATE_LOCATION = "./template/email/";
		String TEMPLATE = "template";
		String CC = "cc";
		String TO = "to";
		String BCC = "bcc";
		String FROM = "from";
		String SUBJECT = "subject";
		String USER_REGISTRATION_TEMPLATE = "USER_REGISTRATION";
	}

}
