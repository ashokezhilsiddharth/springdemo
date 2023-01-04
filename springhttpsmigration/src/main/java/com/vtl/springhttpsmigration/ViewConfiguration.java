package com.vtl.springhttpsmigration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ViewConfiguration implements WebMvcConfigurer {
	
	@Override
	public void addViewControllers(ViewControllerRegistry vcr) {
		vcr.addViewController("/").setViewName("home");
		vcr.addViewController("/home").setViewName("home");
		vcr.addViewController("/greetings").setViewName("greetings");
		
	}

}
