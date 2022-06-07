/**
 * 
 */
package com.lt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lt.dto.Login;
import com.lt.dao.LoginDAO;
import com.lt.exception.NameOrPasswordInvalidException;
import com.lt.service.LoginService;

/**
 * @author admin
 *
 */
@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	LoginDAO loginDAO;
	
	@Override
	public String loginUser(Login login) throws NameOrPasswordInvalidException{
		// TODO Auto-generated method stub
		return loginDAO.loginUser(login);
	}

}
