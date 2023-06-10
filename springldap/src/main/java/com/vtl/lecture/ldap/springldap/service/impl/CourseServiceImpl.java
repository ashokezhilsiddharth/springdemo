package com.vtl.lecture.ldap.springldap.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.vtl.lecture.ldap.springldap.entity.Courses;
import com.vtl.lecture.ldap.springldap.repository.CourseRepository;
import com.vtl.lecture.ldap.springldap.service.CourseService;
@Service
public class CourseServiceImpl implements CourseService {

	private final CourseRepository courseRepository;
	
	
	public CourseServiceImpl(CourseRepository courseRepository) {
		this.courseRepository = courseRepository;		
	}

	@Override
	//@Secured({"ROLE_VTL_LECTURER","ROLE_VTL_TEACHER","ROLE_VTL_TRAINER","ROLE_VTL_LEARNER"})
	public List<Courses> findCourses() {
		return courseRepository.findAll();
	}

	@Override
	//@Secured({"ROLE_VTL_LECTURER","ROLE_VTL_TEACHER","ROLE_VTL_TRAINER"})
	public void addCourse(Courses courses) {
		courseRepository.save(courses);
	}

	@Override
	//@Secured("ROLE_VTL_LECTURER")
	public void removeCourses(Courses courses) {
		Optional<Courses> coursesOptional = courseRepository.findById(courses.getId());
		courseRepository.delete(coursesOptional.get());
		
	}

}
