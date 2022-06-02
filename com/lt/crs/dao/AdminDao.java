package com.lt.crs.dao;

import com.lt.crs.bean.Admin;

public class AdminDao implements AdminDaoInterface{
	public void addProfessor(Admin admin) {
		System.out.println("Professor is added successfully.\n");
		System.out.println("Department = " + admin.getDepartment());
		System.out.println("Designation = " + admin.getDesignation());
	}

	public void approveStudents() {

	}

	public void generateReportCard() {

	}

	public void addCourse() {
		// TODO Auto-generated method stub
		
	}

	public void removeCourse() {
		// TODO Auto-generated method stub
		
	}
}
