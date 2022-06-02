package com.lt.crs.service;

import java.util.List;

import com.lt.crs.bean.Course;
import com.lt.crs.dao.CatalogDao;
import com.lt.crs.dao.CatalogDaoInterface;
import com.lt.crs.exception.CourseNotFoundException;

public class CatalogService implements CatalogServiceInterface{

	public List<Course> addCourse(Course course){
		CatalogDaoInterface catalogDao = new CatalogDao();
		return catalogDao.addCourse( course);
	}
	
	public List<Course> deleteCourse(String CourseName) throws CourseNotFoundException{
		CatalogDaoInterface catalogDao = new CatalogDao();
		return catalogDao.deleteCourse(CourseName);
	}
	
//	public void viewCourseDetails(){
//		
//	}
	public List<Course> viewCourseDetails(){
		CatalogDaoInterface catalogDao = new CatalogDao();
		return catalogDao.viewCourseDetails();
		}
}
