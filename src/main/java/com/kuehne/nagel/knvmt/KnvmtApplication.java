package com.kuehne.nagel.knvmt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class KnvmtApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(KnvmtApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(KnvmtApplication.class);
	}
}
