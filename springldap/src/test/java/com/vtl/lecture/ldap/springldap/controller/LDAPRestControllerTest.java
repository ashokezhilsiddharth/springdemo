package com.vtl.lecture.ldap.springldap.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.vtl.lecture.ldap.springldap.auth.facade.UserContextFacade;
import com.vtl.lecture.ldap.springldap.entity.Courses;
import com.vtl.lecture.ldap.springldap.service.CourseService;

@WebMvcTest(value=LDAPRestController.class, excludeAutoConfiguration = SecurityAutoConfiguration.class)
public class LDAPRestControllerTest {
	@MockBean
	UserContextFacade userContextFacade;
	@MockBean
	CourseService courseService; 
	@Autowired
	MockMvc mockMvc;
	
	private Courses genMockCourses() {
		Courses courses = new Courses();
		courses.setId("1");
		courses.setName("Kubernetes Basics");
		
		return courses;
	}
	
	private List<Courses> genMockListCourses(){
		List<Courses> mockCoursesList = new ArrayList<>();
		mockCoursesList.add(genMockCourses());
		return mockCoursesList;
	}
	
	@Test
	public void testGetAllCourses() throws Exception {
		
		Mockito.when(courseService.findCourses()).thenReturn(genMockListCourses());
		
		
		mockMvc.perform(MockMvcRequestBuilders
				.get("/v1/api/courses")
				
				)
		    .andExpect(status().isOk())
		    .andExpect(jsonPath("$", Matchers.hasSize(1)))
		    .andExpect(jsonPath("$[0].id", is(genMockCourses().getId())))
		    .andExpect(jsonPath("$[0].name", is(genMockCourses().getName())))
		;
		
	}
	
	

}
