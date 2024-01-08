package com.vtl.webclient.courseclient.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

import com.vtl.webclient.courseclient.consumer.CourseConsumer;
import com.vtl.webclient.courseclient.consumer.CourseConsumerImpl;

@Configuration
public class CourseClientConfig {
	
	
	@Bean
	public WebClient webClient() {
		return WebClient.builder().baseUrl("http://localhost:8080/").build();
	}
	
	@Bean
	public CourseConsumer courseConsumer() {
		return new CourseConsumerImpl(webClient());
	}

}
