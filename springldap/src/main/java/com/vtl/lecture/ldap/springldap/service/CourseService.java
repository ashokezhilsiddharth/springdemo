package com.vtl.lecture.ldap.springldap.service;

import java.util.List;

import com.vtl.lecture.ldap.springldap.entity.Courses;

public interface CourseService {
	
	public List<Courses> findCourses();
	public void addCourse(Courses courses);
	public void removeCourses(Courses courses);

}
