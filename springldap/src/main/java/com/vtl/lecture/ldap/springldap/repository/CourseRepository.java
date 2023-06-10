package com.vtl.lecture.ldap.springldap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vtl.lecture.ldap.springldap.entity.Courses;
@Repository
public interface CourseRepository extends JpaRepository<Courses, String> {

	

}
