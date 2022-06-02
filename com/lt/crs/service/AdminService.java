package com.lt.crs.service;

import com.lt.crs.bean.Admin;
import com.lt.crs.dao.AdminDao;

public class AdminService implements AdminServiceInterface {

	public void addProfessor(Admin admin) {
		AdminDao adminDao = new AdminDao();
		adminDao.addProfessor( admin);
	}

	public void approveStudents() {

	}

	public void generateReportCard() {

	}

	public void addCourse() {

	}

	public void removeCourse() {

	}
}
