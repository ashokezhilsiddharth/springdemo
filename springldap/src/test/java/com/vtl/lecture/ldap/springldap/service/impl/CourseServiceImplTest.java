package com.vtl.lecture.ldap.springldap.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.vtl.lecture.ldap.springldap.entity.Courses;
import com.vtl.lecture.ldap.springldap.repository.CourseRepository;

@ExtendWith(MockitoExtension.class)
public class CourseServiceImplTest {
	
	@Mock
	CourseRepository courseRepository;
	
	@InjectMocks
	CourseServiceImpl courseService;
	
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
	public void testRemoveCourses() {
		
		Courses coursesMock = genMockCourses();
		
		Mockito.when(courseRepository.findById(coursesMock.getId())).thenReturn(Optional.of(coursesMock));
		
		Mockito.doNothing().when(courseRepository).delete(coursesMock);
		
		courseService.removeCourses(coursesMock);	
		
		
		
		
	}
	
	
	
	

}
