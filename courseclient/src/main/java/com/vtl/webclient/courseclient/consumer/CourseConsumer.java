package com.vtl.webclient.courseclient.consumer;

import java.util.List;

import com.vtl.webclient.courseclient.dto.CoursesDTO;

public interface CourseConsumer {

	public List<CoursesDTO> findAllCourses();
	public CoursesDTO saveCourse(CoursesDTO coursesDTO);
	public CoursesDTO removeCourse(CoursesDTO coursesDTO);
	
}
