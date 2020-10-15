package com.springb.hrservice.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

//@EnableAutoConfiguration
@SpringBootApplication(scanBasePackages={"com.springb"})
public class Main  extends SpringBootServletInitializer {

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(new Class[] { Main.class});
	}
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(Main.class, args);
	}
}
