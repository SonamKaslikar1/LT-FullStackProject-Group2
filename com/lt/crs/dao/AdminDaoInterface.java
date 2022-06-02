package com.lt.crs.dao;

import com.lt.crs.bean.Admin;

public interface AdminDaoInterface {
	public void addProfessor(Admin admin);

	public void approveStudents();

	public void generateReportCard();

	public void addCourse();

	public void removeCourse();
}
