/**
 * 
 */
package com.lt.crs.service;

import java.util.List;

import com.lt.crs.bean.Course;
import com.lt.crs.exception.CourseNotFoundException;

/**
 * @author user219
 * 
 */
public interface CatalogServiceInterface {

	public List<Course> addCourse(Course ourse);

	public List<Course>  deleteCourse(String CourseName) throws CourseNotFoundException;

	//public void viewCourseDetails();
	public List<Course> viewCourseDetails();
}
