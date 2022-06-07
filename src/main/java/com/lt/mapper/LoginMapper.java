/**
 * 
 */
package com.lt.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.lt.dto.Employee;
import com.lt.dto.Login;

/**
 * @author admin
 *
 */
public class LoginMapper implements RowMapper<Login>{

	@Override
	public Login mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Login login = new Login();
		login.setUsername(rs.getString("username"));
		login.setPassword(rs.getString("password"));
		login.setRole(rs.getString("role"));
		return login;
	}

}
