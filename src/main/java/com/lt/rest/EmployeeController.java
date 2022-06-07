/**
 * 
 */
package com.lt.rest;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lt.dao.EmployeeDAOImpl;

/**
 * @author admin
 *
 */

@RestController
@CrossOrigin
public class EmployeeController {
	
	@Autowired
	EmployeeDAOImpl employeeDAO;
	
	@RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET, value = "/employees")
	@ResponseBody
	public List getStudentDetails() {
		return employeeDAO.listEmployees();

	}
	
	

}
