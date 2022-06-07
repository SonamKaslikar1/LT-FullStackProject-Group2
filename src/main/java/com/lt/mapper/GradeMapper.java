/**
 * 
 */
package com.lt.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.lt.dto.Grade;

/**
 * @author admin
 *
 */
public class GradeMapper implements RowMapper<Grade>{

	@Override
	public Grade mapRow(ResultSet rs, int rowNum) throws SQLException {
		Grade grade = new Grade();
		grade.setMarks(rs.getInt("marks"));
		grade.setGrade(rs.getString("grade"));
		return grade;
	}

}
