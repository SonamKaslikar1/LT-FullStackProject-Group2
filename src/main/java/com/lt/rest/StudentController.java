package com.lt.rest;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lt.dto.Course;
import com.lt.service.StudentServiceImpl;

@RestController
public class StudentController {

	@Autowired
	private StudentServiceImpl studentServiceImpl;

	private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

	/**
	 * 
	 * @return
	 */
	@RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET, value = "/viewCatalog")
	@ResponseBody
	public ResponseEntity<List<Course>> viewCatalog() {
		return new ResponseEntity<List<Course>>(studentServiceImpl.viewCatalog(), HttpStatus.OK);
	}

	/**
	 * 
	 * @param course
	 * @return
	 */
	@RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.POST, value = "/addCourseForStudent")
	@ResponseBody
	public ResponseEntity<List<Course>> addCourse(@RequestBody List<Course> course) {

		return new ResponseEntity<List<Course>>(studentServiceImpl.addCourse(course), HttpStatus.OK);
	}

}
