/**
 * 
 */
package com.lt.dao;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lt.configuration.JDBCConfiguration;
import com.lt.dto.Employee;
import com.lt.mapper.EmployeeMapper;

/**
 * @author 91988
 *
 */

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	// create the reference of looger here

	Logger logger = LoggerFactory.getLogger(EmployeeDAOImpl.class);

	// DI injection of JDBCTemplate

	@Autowired
	JDBCConfiguration jdbcConfiguration;

	@Override
	@Transactional
	public void create(String name, Integer age) {
		// TODO Auto-generated method stub

		String SQL = "insert into employee (name, age) values (?, ?)";

		jdbcConfiguration.jdbcTemplate().update(SQL, name, age);
		System.out.println("Created Record Name = " + name + " Age = " + age);

		return;

	}

	@Override
	public Employee getEmployee(Integer id) {
		// TODO Auto-generated method stub

		String SQL = "select * from employee where id = ?";
		Employee employee = jdbcConfiguration.jdbcTemplate().queryForObject(SQL, new Object[] { id },
				new EmployeeMapper());
		logger.debug("value",
				jdbcConfiguration.jdbcTemplate().queryForObject(SQL, new Object[] { id }, new EmployeeMapper()));
		;
		logger.debug("value of emp-->" + employee.toString());
		return employee;
	}

	@Override
	@Transactional
	public List<Employee> listEmployees() {
		// TODO Auto-generated method stub
		String SQL = "select * from employee";
		List<Employee> employees = jdbcConfiguration.jdbcTemplate().query(SQL, new EmployeeMapper());
		logger.debug("in debug");
		return employees;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub

		String SQL = "delete from employee where id = ?";
		jdbcConfiguration.jdbcTemplate().update(SQL, id);
		System.out.println("Deleted Record with ID = " + id);
		return;
	}

	@Override
	public void update(Integer id, Integer age) {
		// TODO Auto-generated method stub
		String SQL = "update employee set age = ? where id = ?";
		jdbcConfiguration.jdbcTemplate().update(SQL, age, id);
		System.out.println("Updated Record with ID = " + id);
		return;
	}

}
