package com.vtl.webclient.courseclient.consumer;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestBodySpec;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vtl.webclient.courseclient.dto.CoursesDTO;

import reactor.core.publisher.Mono;

public class CourseConsumerImpl implements CourseConsumer {

	private WebClient webClient;

	public CourseConsumerImpl(WebClient webClient) {
		this.webClient = webClient;
	}

	@Override
	public List<CoursesDTO> findAllCourses() {
		Mono<Object[]> monoResponses = webClient
				                             .get()
				                             .uri("/v1/api/courses")
				                             .accept(MediaType.APPLICATION_JSON)
				                             .retrieve()
				                             .bodyToMono(Object[].class)
				                             .log();
		Object[] responses = monoResponses.block();
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		return Arrays.stream(responses)
		       .map(response->objectMapper.convertValue(response, CoursesDTO.class))
		       .collect(Collectors.toList());
		
		
	}

	@Override
	public CoursesDTO saveCourse(CoursesDTO coursesDTO) {
		
		Mono<Object> monoResponse = webClient
				                      .post()
				                      .uri("/v1/api/addCourse")
				                      .accept(MediaType.APPLICATION_JSON)
				                      .body(Mono.just(coursesDTO), CoursesDTO.class)
			                          .retrieve()
			                          .bodyToMono(Object.class)
			                          .log();
		
		Object response = monoResponse.block();
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		
		
		return objectMapper.convertValue(response, CoursesDTO.class);
	}

	@Override
	public CoursesDTO removeCourse(CoursesDTO coursesDTO) {
		
		Mono<Object> monoResponse = ((RequestBodySpec)webClient
                .delete()
                .uri("/v1/api/deleteCourse")
                .accept(MediaType.APPLICATION_JSON))
				.body(Mono.just(coursesDTO), CoursesDTO.class)
                .retrieve()
                .bodyToMono(Object.class)
                .log();
		
		
		
		Object response = monoResponse.block();
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		
		
		return objectMapper.convertValue(response, CoursesDTO.class);
		
	}

}
