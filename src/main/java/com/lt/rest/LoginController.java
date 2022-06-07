/**
 * 
 */
package com.lt.rest;

import java.time.LocalDateTime;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lt.dto.Course;
import com.lt.dto.Login;
import com.lt.exception.NameOrPasswordInvalidException;
import com.lt.service.LoginService;

/**
 * @author admin
 *
 */
@RestController
@CrossOrigin
public class LoginController {

	@Autowired
	LoginService loginService;

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	private LocalDateTime localDateTime = LocalDateTime.now();

	/**
	 * 
	 * @param login
	 * @return
	 */
	@RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.POST, value = "/loginUser")
	@ResponseBody
	public String loginUser(@RequestBody Login login) {
		try {
			logger.info("Inside LoginController login user");
			String flag = loginService.loginUser(login);
			String message = "";
			if (flag.equals("SUCCESS")) {
				if (("admin").equals(login.getUsername())) {
					message = "Welcome Admin----Login DateTime is : " + localDateTime;
				} else if (("student").equals(login.getUsername())) {
					message = "Welcome Student----Login DateTime is : " + localDateTime;
				} else {
					message = "Welcome Professor----Login DateTime is : " + localDateTime;
				}
			}
			return message;
		} catch (NameOrPasswordInvalidException e) {
			logger.error("Exception in loginUser() method in LoginController : " + e.getMessage());
			return "Invalid username/password";
		}
	}

}
