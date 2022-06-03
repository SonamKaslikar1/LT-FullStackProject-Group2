package com.lt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lt.bean.Admin;
import com.lt.bean.Course;
import com.lt.dao.AdminDao;
import com.lt.dao.CatalogDao;
import com.lt.dao.CatalogDaoInterface;
import com.lt.dao.StudentDao;
import com.lt.dao.StudentDaoInterface;
import com.lt.exception.CourseNotFoundException;
import com.lt.exception.GradeNotWithinRangeException;

@Service
public class AdminService implements AdminServiceInterface {

	public void addProfessor(Admin admin) {
		AdminDao adminDao = new AdminDao();
		adminDao.addProfessor(admin);
	}

	public void approveStudents(int input) {
		AdminDao adminDao = new AdminDao();
		adminDao.approveStudents(input);
	}

	public void generateReportCard(int studentId, int sum) throws GradeNotWithinRangeException {
		AdminDao adminDao = new AdminDao();
		adminDao.generateReportCard(studentId, sum);
	}

	public List<Course> addCourse(Course course) {
		AdminDao adminDao = new AdminDao();
		return adminDao.addCourse(course);
	}

	public List<Course> deleteCourse(String CourseName) throws CourseNotFoundException {
		AdminDao adminDao = new AdminDao();
		return adminDao.deleteCourse(CourseName);
	}

	public List<Course> viewCourseDetails() {
		AdminDao adminDao = new AdminDao();
		return adminDao.viewCourseDetails();
	}
}
