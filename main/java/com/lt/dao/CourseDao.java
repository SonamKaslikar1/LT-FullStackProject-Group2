package com.lt.dao;

import java.util.ArrayList;
import java.util.List;

import com.lt.bean.Student;

public class CourseDao implements CourseDaoInterface{
	/**
	 * Returns the list of all the courses.
	 */

	@Override
	public List returnCoursesList() {
		// TODO Auto-generated method stub
		List courseList = new ArrayList<>();
		courseList.add("Computer Science");
		courseList.add("Data Mining");
		courseList.add("Data Science");
		courseList.add("Data Architect");

		return courseList;

	}
	
	public List returnAllCoursesList() {
		List allCoursesList = new ArrayList<>();
		allCoursesList.add("Computer Science");
		allCoursesList.add("Data Mining");
		allCoursesList.add("Data Science");
		allCoursesList.add("Data Architect");
		allCoursesList.add("Data Scientist");
		return allCoursesList;
		
		
	}
	
		


//	@Override
//	public List<String> getCourses() {
//		// TODO Auto-generated method stub
//		List  availableCourses=new ArrayList<>();
//		return availableCourses;
//	}
//	
}
