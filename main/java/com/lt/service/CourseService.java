package com.lt.service;

import java.util.List;

import com.lt.bean.Student;
import com.lt.dao.CourseDao;
import com.lt.dao.CourseDaoInterface;

public class CourseService implements CourseServiceInterface{

	CourseDaoInterface courseDao = new CourseDao();
	public void listCourses()  {
		CourseDao courseDao = new CourseDao();
		System.out.println(courseDao.returnCoursesList());
		
	}
	
	public void addCourses() {
	}
	
}
