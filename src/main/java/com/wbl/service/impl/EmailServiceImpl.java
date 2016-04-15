package com.wbl.service.impl;

import java.util.Map;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.velocity.app.VelocityEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;

import com.wbl.service.EmailService;
import com.wbl.util.AppConstants;

@Service
public class EmailServiceImpl implements EmailService {
	private static final Logger logger = LoggerFactory.getLogger(EmailServiceImpl.class);
	@Qualifier("mailSender")
	private final JavaMailSender javaMailSender;

	private final VelocityEngine velocityEngine;

	@Autowired
	public EmailServiceImpl(JavaMailSender javaMailSender, VelocityEngine velocityEngine) {
		if (javaMailSender == null) {
			throw new IllegalArgumentException("javaMailSender cannot be null");
		}
		if (velocityEngine == null) {
			throw new IllegalArgumentException("velocityEngine cannot be null");
		}
		this.javaMailSender = javaMailSender;
		this.velocityEngine = velocityEngine;
	}

	@Async
	public void sendEmail(final Map<String, Object> params) {
		logger.debug("Email Service starts");

		MimeMessagePreparator preparator = new MimeMessagePreparator() {
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
				if (params.get(AppConstants.EMAIL.FROM) != null) {
					mimeMessage.setFrom(new InternetAddress((String) params.get(AppConstants.EMAIL.FROM)));
					mimeMessage.setFrom();
					message.setFrom((String) params.get(AppConstants.EMAIL.FROM), "Win By Luck");
					message.setFrom(new InternetAddress((String) params.get(AppConstants.EMAIL.FROM)));
					message.setFrom((String) params.get(AppConstants.EMAIL.FROM), "Win By Luck");
				}
				if (params.get(AppConstants.EMAIL.TO) != null)
					message.setTo((String[]) params.get(AppConstants.EMAIL.TO));
				if (params.get(AppConstants.EMAIL.CC) != null)
					message.setCc((String[]) params.get(AppConstants.EMAIL.CC));
				if (params.get(AppConstants.EMAIL.BCC) != null)
					message.setBcc((String[]) params.get(AppConstants.EMAIL.BCC));
				if (params.get(AppConstants.EMAIL.SUBJECT) != null)
					message.setSubject((String) params.get(AppConstants.EMAIL.SUBJECT));
				String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine,
						AppConstants.EMAIL.TEMPLATE_LOCATION + params.get(AppConstants.EMAIL.TEMPLATE) + ".vm",
						AppConstants.EMAIL.ENCODING, params);
				message.setText(text, true);
			}
		};

		javaMailSender.send(preparator);
		logger.debug("Email Service ends");
	}

}
