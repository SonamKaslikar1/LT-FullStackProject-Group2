/**
 * 
 */
package com.lt.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.lt.dto.Professor;

/**
 * @author admin
 *
 */
public class ProfessorMapper implements RowMapper<Professor>{

	@Override
	public Professor mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Professor professor = new Professor();
		professor.setProfName(rs.getString("professorName"));
		professor.setDepartment(rs.getString("department"));
		professor.setDesignation(rs.getString("designation"));
		return professor;
	}

}
