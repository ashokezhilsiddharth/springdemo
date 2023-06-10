package com.vtl.lecture.ldap.springldap.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vtl.lecture.ldap.springldap.auth.context.UserContext;
import com.vtl.lecture.ldap.springldap.auth.facade.UserContextFacade;
import com.vtl.lecture.ldap.springldap.dto.CoursesDTO;
import com.vtl.lecture.ldap.springldap.entity.Courses;
import com.vtl.lecture.ldap.springldap.service.CourseService;



@RestController
public class LDAPRestController {
	
	private final UserContextFacade userContextFacade;
	
    private final CourseService courseService; 
    
        
    public LDAPRestController(UserContextFacade userAuthFacade,CourseService courseService) {
    	this.userContextFacade = userAuthFacade;
    	this.courseService = courseService;    	
    }
	
	@PostMapping("/v1/api/authn")
    public UserContext getAuth() {
		return userContextFacade.getUserContext();
    }
    
    @GetMapping("/securegreetings")
	public String secureGreetings() {
		UserContext userContext = userContextFacade.getUserContext();
		StringBuilder  messageBuilder = new StringBuilder();
		messageBuilder.append("Welecome and Thanks! ");
		messageBuilder.append(userContext.getUserName());
		messageBuilder.append(" for joining us. ");
		
		List<String> roles = userContext.getRoles();
		if(null!=userContext.getRoles() && !userContext.getRoles().isEmpty()) {
			messageBuilder.append(" You are onboarded in the role of " );
			for(String role: roles) {
				messageBuilder.append(role);
			}
			
		}
		return messageBuilder.toString();
	}
	
	
	@PostMapping("/v1/api/addCourse")
	public ResponseEntity<CoursesDTO> addCourse(@RequestBody CoursesDTO coursesDTO) {
		Courses courses = new Courses();
		courses.setId(coursesDTO.getId());
		courses.setName(coursesDTO.getName());
		courseService.addCourse(courses);		
		return new ResponseEntity<CoursesDTO>(coursesDTO, HttpStatusCode.valueOf(201));		
		
	}
	@GetMapping("/v1/api/courses")
	public ResponseEntity<List<CoursesDTO>> getAllCourses() {	
		List<Courses> coursesList = courseService.findCourses();
		List<CoursesDTO> coursesDTOs = new  ArrayList<CoursesDTO>();
		for(Courses courses: coursesList) {
			CoursesDTO coursesDTO = new CoursesDTO();
			coursesDTO.setId(courses.getId());
			coursesDTO.setName(courses.getName());
			coursesDTOs.add(coursesDTO);
			
		}
		return new ResponseEntity<List<CoursesDTO>>(coursesDTOs, HttpStatusCode.valueOf(200));		
		
	}
	
	@DeleteMapping("/v1/api/deleteCourse")
	public ResponseEntity<CoursesDTO> removeCourse(@RequestBody CoursesDTO coursesDTO){
	Courses courses = new Courses();
		courses.setId(coursesDTO.getId());
		courses.setName(coursesDTO.getName());
		courseService.removeCourses(courses);
		return new ResponseEntity<CoursesDTO>(coursesDTO, HttpStatusCode.valueOf(200));		
	}

}
