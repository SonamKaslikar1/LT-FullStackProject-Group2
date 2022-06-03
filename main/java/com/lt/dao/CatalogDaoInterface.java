package com.lt.dao;

import java.util.List;

import com.lt.bean.Course;
import com.lt.exception.CourseNotFoundException;

public interface CatalogDaoInterface {
	public List<Course> addCourse(Course course);

	public List<Course> deleteCourse(String CourseName) throws CourseNotFoundException;

	public List<Course> viewCourseDetails();
	
	
	
}
