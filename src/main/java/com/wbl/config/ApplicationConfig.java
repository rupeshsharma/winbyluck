package com.wbl.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component("appConfig")
@PropertySource(value = { "classpath:application.properties" })
public class ApplicationConfig {

	@Autowired
	private Environment env;

	public String get(String key) {
		return env.getProperty(key);
	}

}
