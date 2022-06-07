/**
 * 
 */
package com.lt.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.lt.dto.Student;

/**
 * @author admin
 *
 */
public class StudentMapper implements RowMapper<Student>{

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Student student = new Student();
		student.setId(rs.getString("studentId"));
		student.setName(rs.getString("studentName"));
		return student;
	}

}
