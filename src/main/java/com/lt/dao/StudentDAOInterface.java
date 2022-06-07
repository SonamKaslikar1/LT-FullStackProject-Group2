package com.lt.dao;

import java.util.List;

import com.lt.dto.Course;

public interface StudentDAOInterface {

	public List<Course> viewCatalog();

	public List<Course> addCourse(List<Course> course);

}
