/**
 * 
 */
package com.lt.service;

import java.util.List;

import com.lt.bean.Admin;
import com.lt.bean.Course;
import com.lt.exception.CourseNotFoundException;
import com.lt.exception.GradeNotWithinRangeException;

/**
 * @author user219
 * 
 */
public interface AdminServiceInterface {

	public void addProfessor(Admin admin);

	public void approveStudents(int input);

	public void generateReportCard(int studentId, int sum) throws GradeNotWithinRangeException;

	public List<Course> addCourse(Course course);

	public List<Course> deleteCourse(String CourseName) throws CourseNotFoundException;

	public List<Course> viewCourseDetails();
}
