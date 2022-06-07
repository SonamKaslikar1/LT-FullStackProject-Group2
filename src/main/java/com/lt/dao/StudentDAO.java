package com.lt.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.lt.dto.Course;

/**
 * 
 * @author Omkar
 *
 */
@Repository
public class StudentDAO implements StudentDAOInterface {

	private static final Logger logger = LoggerFactory.getLogger(StudentDAO.class);

	public static List<Course> courselist = new ArrayList<Course>();

	/**
	 * 
	 */
	@Override
	public List<Course> viewCatalog() {
		Course course = new Course();
		course.setCourseName("Maths");
		courselist.add(course);
		return courselist;
	}

	/**
	 * 
	 */
	@Override
	public List<Course> addCourse(List<Course> course) {
		// TODO Auto-generated method stub
		for (Course c : course) {
			courselist.add(c);
		}
		return courselist;
	}

}
