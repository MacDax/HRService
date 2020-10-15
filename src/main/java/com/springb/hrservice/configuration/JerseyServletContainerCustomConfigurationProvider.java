package com.springb.hrservice.configuration;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Configuration;

import com.springb.hrservice.api.V1JaxRsApplication;


public class JerseyServletContainerCustomConfigurationProvider implements JerseyServletContainerConfigurationProvider{
	@Override
	public Set<Class<?>> getConfigurationClasses() {
		Set<Class<?>> x = new HashSet<Class<?>>();
		x.add(V1JaxRsApplication.class);
		return x;
	}
	
	
}
