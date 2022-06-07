/**
 * 
 */
package com.lt.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.lt.dto.Employee;

/**
 * @author 91988
 *
 */
public class EmployeeMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub

		Employee employee = new Employee();
		employee.setName(rs.getString("name"));
		employee.setAge(rs.getInt("age"));
		employee.setId(rs.getInt("id"));
		return employee;

	}
}