package com.lt.crs.dao;

import java.util.List;

import com.lt.crs.bean.Course;
import com.lt.crs.exception.CourseNotFoundException;

public interface CatalogDaoInterface {
	public List<Course> addCourse(Course course);

	public List<Course> deleteCourse(String CourseName) throws CourseNotFoundException;

	public List<Course> viewCourseDetails();
	
	
	
}
