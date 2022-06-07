package com.lt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lt.dto.Course;
import com.lt.dto.Grade;
import com.lt.dao.StudentDAOInterface;
import com.lt.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDAOInterface studentDAOInterface;

	@Override
	public List<Course> addCourse(List<Course> course) {

		return studentDAOInterface.addCourse(course);
	}

	@Override
	public String courseRegistration(List<Course> courseRegistrationObj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String dropCourse(String course) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Grade> viewGrades() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Course> viewCatalog() {
		// TODO Auto-generated method stub
		return studentDAOInterface.viewCatalog();

	}
}
