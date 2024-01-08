package com.vtl.webclient.courseclient;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.vtl.webclient.courseclient.config.CourseClientConfig;
import com.vtl.webclient.courseclient.consumer.CourseConsumer;
import com.vtl.webclient.courseclient.dto.CoursesDTO;

public class CourseClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(CourseClientConfig.class);
		
	CourseConsumer courseConsumer =  applicationContext.getBean(CourseConsumer.class);
	
	System.out.println(courseConsumer.findAllCourses());
	
	CoursesDTO coursesDTO = new CoursesDTO();
	coursesDTO.setId("110043");
	coursesDTO.setName("Kubernetes Basics");
	//System.out.println(courseConsumer.saveCourse(coursesDTO));
	
	//System.out.println(courseConsumer.removeCourse(coursesDTO));

	}

}
