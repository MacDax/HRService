package com.springb.hrservice.configuration;

import java.util.Optional;

import javax.inject.Inject;

import org.eclipse.microprofile.config.Config;

public class EnvConfigUtil {

	@Inject
	static Config config;
	
	public static String getAsString(String propertyName, String defaultValue) {
		Optional<String> propertyValue = config.getOptionalValue(propertyName, String.class);
		return propertyValue.orElseGet(() -> defaultValue);
	}
}
