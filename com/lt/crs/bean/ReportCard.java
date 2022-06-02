package com.lt.crs.bean;

import java.util.List;
import java.util.UUID;

public class ReportCard {

	private UUID studentId;
	private int semester;
	private float gpa;
	private List<RegisteredCourse> registeredCourses;
	
	public UUID getStudentId() {
		return studentId;
	}
	public void setStudentId(UUID studentId) {
		this.studentId = studentId;
	}
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}
	public float getGpa() {
		return gpa;
	}
	public void setGpa(float gpa) {
		this.gpa = gpa;
	}
	public List<RegisteredCourse> getRegisteredCourses() {
		return registeredCourses;
	}
	public void setRegisteredCourses(List<RegisteredCourse> registeredCourses) {
		this.registeredCourses = registeredCourses;
	}
	
}
