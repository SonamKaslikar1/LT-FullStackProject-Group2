package com.lt.dto;

public class Course {

	private String courseCode;
	private String courseName;
	private String isOffered;
	private String instructor;

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getIsOffered() {
		return isOffered;
	}

	public void setIsOffered(String isOffered) {
		this.isOffered = isOffered;
	}

	public String getInstructor() {
		return instructor;
	}

	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}

	public Course(String courseCode, String courseName, String isOffered, String instructor) {
		super();
		this.courseCode = courseCode;
		this.courseName = courseName;
		this.isOffered = isOffered;
		this.instructor = instructor;
	}

	public Course() {
		super();
	}

	@Override
	public String toString() {
		return "Course [courseCode=" + courseCode + ", courseName=" + courseName + ", isOffered=" + isOffered
				+ ", instructor=" + instructor + "]";
	}

}
