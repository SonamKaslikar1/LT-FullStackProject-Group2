package com.lt.dao;

import java.util.List;

import com.lt.bean.Admin;
import com.lt.bean.Course;
import com.lt.exception.CourseNotFoundException;
import com.lt.exception.GradeNotWithinRangeException;

public interface AdminDaoInterface {
	public void addProfessor(Admin admin);

	public void approveStudents(int input);

	public void generateReportCard(int studentId, int sum) throws GradeNotWithinRangeException;

	public List<Course> addCourse(Course ourse);

	public List<Course> deleteCourse(String CourseName) throws CourseNotFoundException;

	public List<Course> viewCourseDetails();
}
