/**
 * 
 */
package com.lt.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lt.configuration.JDBCConfiguration;
import com.lt.constants.JDBCTemplateConstants;
import com.lt.dto.Course;
import com.lt.dto.Employee;
import com.lt.dto.Login;
import com.lt.exception.CourseNotFoundException;
import com.lt.exception.NameOrPasswordInvalidException;
import com.lt.mapper.EmployeeMapper;
import com.lt.mapper.LoginMapper;

/**
 * @author admin
 *
 */
@Repository
public class LoginDAO implements LoginDAOInterface {
	private static final Logger logger = LoggerFactory.getLogger(AdminDAO.class);

	@Autowired
	JDBCConfiguration jdbcConfiguration;
	@Autowired
	JDBCTemplateConstants jdbcTemplateConstants;
	/**
	 * 
	 * @return
	 */
	@Transactional
	public List<Login> veiwLoginUserList() {
		// TODO Auto-generated method stub
		
		List<Login> loginUserList = jdbcConfiguration.jdbcTemplate().query(jdbcTemplateConstants.loginCheckSQL, new LoginMapper());
		logger.debug("in debug");
		return loginUserList;
	}

	/**
	 * this method is used to authenticate the login credentials 
	 * login details is taken as input parameters
	 */
	@Override
	@Transactional
	public String loginUser(Login login) throws NameOrPasswordInvalidException {
		// TODO Auto-generated method stub
		List<Login> loginUserList = veiwLoginUserList();
		List<Login> loginlist = loginUserList.stream()
				.filter(n -> (n.getUsername().equals(login.getUsername())
						&& (n.getPassword().equals(login.getPassword()) && (n.getRole().equals(login.getRole())))))
				.collect(Collectors.toList());
		if (loginlist.size() != 0) {

			logger.info("Loggin in   :" + login.getUsername());
			return "SUCCESS";

		} else {
			logger.error("Error in Logging in : " + login.getUsername());
			throw new NameOrPasswordInvalidException("Please enter username/password again.");
		}
	}

}
