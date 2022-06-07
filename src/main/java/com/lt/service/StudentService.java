package com.lt.service;

import java.util.List;

import com.lt.dto.Course;
import com.lt.dto.Grade;

public interface StudentService {

	public List<Course> addCourse(List<Course> course);

	public String courseRegistration(List<Course> courseRegistrationObj);

	public String dropCourse(String course);

	public List<Course> viewCatalog();

	public List<Grade> viewGrades();

	

}
