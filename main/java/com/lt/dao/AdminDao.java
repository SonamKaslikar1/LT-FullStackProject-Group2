package com.lt.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.lt.bean.Admin;
import com.lt.bean.Course;
import com.lt.exception.CourseNotFoundException;
import com.lt.exception.GradeNotWithinRangeException;
import com.lt.exception.WrongOption;

public class AdminDao implements AdminDaoInterface {

	public void addProfessor(Admin admin) {
		System.out.println("Professor is added successfully.\n");
		System.out.println("Department = " + admin.getDepartment());
		System.out.println("Designation = " + admin.getDesignation());
	}

	public void approveStudents(int inp) {
		if (inp == 1) {
			System.out.println("Successfully Registered for Java Course");
		} else if (inp == 2) {
			System.out.println("Successfully Registered for Python Course");
		} else if (inp == 3) {
			System.out.println("Successfully Registered for Big data Course");
		} else if (inp == 4) {
			System.out.println("Successfully Registered for Cloud Course");
		} else if (inp > 4) {
			try {
				throw new WrongOption("Wrong Option Chosen. Choose the valid option.");
			} catch (WrongOption e) {
				System.out.println(e);
			}
		}
	}

	public void generateReportCard(int studentId, int sum) throws GradeNotWithinRangeException {
		String grade = "";
		int mean = sum / 4;
		if (mean >= 80) {
			grade = "A";
		} else if (mean < 80 && mean >= 60) {
			grade = "B";
		} else if (mean < 60 && mean >= 40) {
			grade = "C";
		} else {
			grade = "D";
		}
		if (mean < 100) {
			System.out.println("Grade for Student Id " + studentId + " is " + grade);
		} else {
			throw new GradeNotWithinRangeException("Grade is not within the range of 100.");
		}
	}

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
