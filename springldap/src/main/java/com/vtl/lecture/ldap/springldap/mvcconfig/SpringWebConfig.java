package com.vtl.lecture.ldap.springldap.mvcconfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SpringWebConfig implements WebMvcConfigurer {
	
    @Override
	public void addViewControllers(ViewControllerRegistry registry) {
    	registry.addViewController("/").setViewName("home");		
		registry.addViewController("/home").setViewName("home");		
		registry.addViewController("/unsecuregreetings").setViewName("unsecuregreetings");
		registry.addViewController("/securegreetings").setViewName("securegreetings");
		registry.addViewController("/authenticate").setViewName("authenticate");
		registry.addViewController("/login").setViewName("login");
	}

}