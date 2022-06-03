/**
 * 
 */
package com.lt.service;

import java.util.List;

import com.lt.bean.Course;
import com.lt.exception.CourseNotFoundException;

/**
 * @author user219
 * 
 */
public interface CatalogServiceInterface {

	public List<Course> addCourse(Course ourse);

	public List<Course> deleteCourse(String CourseName) throws CourseNotFoundException;

	public List<Course> viewCourseDetails();
}
