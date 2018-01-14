package com.trizic.coding;

import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = { "com.trizic" })
public class AdvisorApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(AdvisorApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(AdvisorApplication.class, args);
	}

	@Bean
	public SessionFactory sessionFactory(HibernateEntityManagerFactory hibernateEntityManagerFactory) {
		return hibernateEntityManagerFactory.getSessionFactory();
	}
}
