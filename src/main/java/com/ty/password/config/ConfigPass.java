package com.ty.password.config;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.ty.password"})
public class ConfigPass {
	
	@Bean("em")
	@Scope("prototype")
	public EntityManager getEntityManagerFactory()
	{
		return Persistence.createEntityManagerFactory("password").createEntityManager();
	}

}
