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
import com.lt.dto.Grade;
import com.lt.dto.Student;
import com.lt.exception.GradeNotWithinRangeException;
import com.lt.service.AdminServiceImpl;
import com.lt.service.ProfessorServiceImpl;

@RestController
public class ProfessorController {
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

	@Autowired
	AdminServiceImpl adminServiceImpl;

	@Autowired
	ProfessorServiceImpl professorServiceImpl;

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET, value = "/viewCourseForProfessor")
	@ResponseBody
	public ResponseEntity<List<Course>> viewCourse() {
		try {
			logger.info("Inside ProfessorController view course");
			return new ResponseEntity<List<Course>>(adminServiceImpl.veiwCourse(), HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Exception in viewCourse() method in controller" + e.getMessage());
			return new ResponseEntity<List<Course>>(HttpStatus.NOT_FOUND);

		}
	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET, value = "/viewStudentsforProfessor")
	@ResponseBody
	public ResponseEntity<List<Student>> viewStudents() {
		try {
			logger.info("Inside AdminController view students ");
			return new ResponseEntity<List<Student>>(adminServiceImpl.viewStudents(), HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Exception in viewStudents() method in controller" + e.getMessage());
			return new ResponseEntity<List<Student>>(HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * 
	 * @param sum
	 * @return
	 * @throws GradeNotWithinRangeException
	 */
	@RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.POST, value = "/addGrades")
	@ResponseBody
	public ResponseEntity<String> addGrades(@RequestBody int sum) {
		try {
			logger.info("Inside Professor add grades");
			return new ResponseEntity<String>(professorServiceImpl.addGrades(sum), HttpStatus.OK);
		} catch (GradeNotWithinRangeException e) {
			logger.error("Exception in addGrades() method in controller" + e.getMessage());
			return new ResponseEntity<String>("Exception in addGrades() : " + sum, HttpStatus.NOT_FOUND);

		}
	}
}
