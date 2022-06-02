package com.lt.crs.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.lt.crs.bean.Course;
import com.lt.crs.exception.CourseNotFoundException;

public class CatalogDao implements CatalogDaoInterface {
	public List<Course> addCourse(Course course) {

		List<Course> courselist = viewCourseDetails();
		int size = courselist.size();
		courselist.add(size, course);
		return courselist;

	}

	public List<Course> deleteCourse(String CourseName) throws CourseNotFoundException {

		List<Course> courselist = viewCourseDetails();
		int count = 0;
		Iterator<Course> courselistIterator = courselist.iterator();
		while (courselistIterator.hasNext()) {
			if (courselistIterator.next().getName().equals(CourseName)) {
				courselistIterator.remove();
				count++;
			}
		}
		if (count == 0) {
			throw new CourseNotFoundException("Course name with the given name is not found.");

		}

		return courselist;
	}

//	public void viewCourseDetails() {
//
//	}
	public List<Course> viewCourseDetails() {

		List<Course> courseList = new ArrayList<Course>();

		Course course = new Course();
		Course course1 = new Course("101", "Physics", true, "ABC");
		Course course2 = new Course("102", "Chemistry", true, "DEF");
		Course course3 = new Course("103", "Maths", true, "XYZ");
		Course course4 = new Course("104", "English", true, "YHHG");

		courseList.add(course1);
		courseList.add(course2);
		courseList.add(course3);
		courseList.add(course4);

//		courseList.add("Physics");
//		courseList.add("Chemistry");
//		courseList.add("Maths");
//		courseList.add("English");
		return courseList;
	}
}
