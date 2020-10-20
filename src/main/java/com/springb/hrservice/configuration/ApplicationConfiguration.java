package com.springb.hrservice.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.spring.boot.framework.dbdelegate.configuration.DatabaseManager;
import com.spring.boot.personsdb.transactions.GetPersonalDataDelegate;

@Configuration
public class ApplicationConfiguration {

	@Bean
	public GetPersonalDataDelegate getPersonalDataDelegate() {
		return new GetPersonalDataDelegate();
	}
	
	@Bean
	public DatabaseManager dbManager() {
		return new DatabaseManager();
	}
}
