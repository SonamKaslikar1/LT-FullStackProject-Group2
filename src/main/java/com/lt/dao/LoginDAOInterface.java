/**
 * 
 */
package com.lt.dao;

import com.lt.dto.Login;
import com.lt.exception.NameOrPasswordInvalidException;

/**
 * @author admin
 *
 */
public interface LoginDAOInterface {
	public String loginUser(Login login) throws NameOrPasswordInvalidException;

}
