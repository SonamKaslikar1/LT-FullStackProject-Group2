package com.lt.crs.service;

import java.util.List;

import com.lt.crs.bean.Student;
import com.lt.crs.dao.CourseDao;
import com.lt.crs.dao.CourseDaoInterface;

public class CourseService implements CourseServiceInterface{

	CourseDaoInterface courseDao = new CourseDao();
	public void listCourses()  {
		CourseDao courseDao = new CourseDao();
		System.out.println(courseDao.returnCoursesList());
		
	}
	
	public void addCourses() {
	}
	
}
