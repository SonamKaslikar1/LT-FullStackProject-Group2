package com.lt.dto;

public class Grade {
	private int marks;
	private String grade;

	public Grade(int marks, String grade) {
		super();
		this.marks = marks;
		this.grade = grade;
	}

	public Grade() {
		super();
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

}
