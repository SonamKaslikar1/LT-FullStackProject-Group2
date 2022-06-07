/**
 * 
 */
package com.lt.service;

import com.lt.dto.Login;
import com.lt.exception.NameOrPasswordInvalidException;

/**
 * @author admin
 *
 */
public interface LoginService {

	public String loginUser(Login login) throws NameOrPasswordInvalidException;
}
