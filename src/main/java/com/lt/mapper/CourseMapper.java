/**
 * 
 */
package com.lt.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.lt.dto.Course;
import com.lt.dto.Employee;

/**
 * @author admin
 *
 */
public class CourseMapper implements RowMapper<Course> {

	@Override
	public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Course course = new Course();
		course.setCourseCode(rs.getString("courseCode"));
		course.setCourseName(rs.getString("courseName"));
		course.setIsOffered(rs.getString("isOffered"));
		course.setInstructor(rs.getString("professorName"));
		return course;
	}

}
