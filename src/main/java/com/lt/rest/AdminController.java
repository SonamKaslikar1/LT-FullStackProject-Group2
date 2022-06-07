package com.lt.rest;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lt.dto.Course;
import com.lt.dto.Professor;
import com.lt.dto.Student;
import com.lt.exception.CourseNotFoundException;
import com.lt.exception.ProfessorNotFoundException;
import com.lt.exception.StudentNotFoundException;
import com.lt.service.AdminService;

@RestController
@CrossOrigin
/**
 * 
 * @author admin
 * 
 *         This class is used as a admin rest controller and all the URI/URL
 *         requests will go to service.
 * 
 *         methods used : addCourse(List course); addProfessor(List Professor);
 *         addStudent(List Student); viewCourse(); viewStudent();
 *         veiwProfessor(); removeCourse(code); removeStudent(id);
 *         removeProfessor(name)
 *
 */
public class AdminController {

	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

	@Autowired
	private AdminService adminServiceImpl;

	/**
	 * This method is used to add list of courses by admin
	 * 
	 * @param course it accepts the courses list and it will get added to existing
	 *               courses
	 * 
	 * @return it will return the list of all courses after adding
	 */
	@RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.POST, value = "/addCourse")
	@ResponseBody
	public ResponseEntity<List<Course>> addCourse(@RequestBody List<Course> course) {
		try {
			logger.info("Inside AdminController add course");
			return new ResponseEntity<List<Course>>(adminServiceImpl.addCourse(course), HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Exception in addcourse() method in controller" + e.getMessage());
			return new ResponseEntity<List<Course>>(HttpStatus.NOT_FOUND);

		}
	}

	/**
	 * This method is used to add list of professors by admin
	 * 
	 * @param Professor it accepts the professors list and it will get added to
	 *                  existing professors
	 * 
	 * @return it will return the list of all professors after adding
	 */
	@RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.POST, value = "/addProfessor")
	public ResponseEntity<List<Professor>> addProfessor(@RequestBody List<Professor> professor) {
		try {
			logger.info("Inside AdminController add professor");
			return new ResponseEntity<List<Professor>>(adminServiceImpl.addProfessor(professor), HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Exception in addProfessor() method in controller" + e.getMessage());
			return new ResponseEntity<List<Professor>>(HttpStatus.NOT_FOUND);

		}

	}

	/**
	 * This method is used to add list of student by admin
	 * 
	 * @param student it accepts the student list and it will get added to existing
	 *                student
	 * 
	 * @return it will return the list of all student after adding
	 */

	@RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.POST, value = "/addStudent")
	public ResponseEntity<List<Student>> addStudent(@RequestBody List<Student> student) {
		try {
			logger.info("Inside AdminController add student");
			return new ResponseEntity<List<Student>>(adminServiceImpl.addStudent(student), HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Exception in addStudent() method in controller" + e.getMessage());
			return new ResponseEntity<List<Student>>(HttpStatus.NOT_FOUND);

		}
	}

	/**
	 * This method is used to view the courses by admin
	 * 
	 * @return List of courses
	 */

	@RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET, value = "/viewCourse")
	@ResponseBody
	public ResponseEntity<List<Course>> viewCourse() {
		try {
			logger.info("Inside AdminController view course");
			return new ResponseEntity<List<Course>>(adminServiceImpl.veiwCourse(), HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Exception in viewCourse() method in controller" + e.getMessage());
			return new ResponseEntity<List<Course>>(HttpStatus.NOT_FOUND);

		}
	}

	/**
	 * This method is used to view the professors by admin
	 * 
	 * @return List of professors
	 */

	@RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET, value = "/viewProfessor")
	@ResponseBody
	public ResponseEntity<List<Professor>> viewProfessor() {
		try {
			logger.info("Inside AdminController view professor ");
			return new ResponseEntity<List<Professor>>(adminServiceImpl.veiwProfessor(), HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Exception in viewProfessor() method in controller" + e.getMessage());
			return new ResponseEntity<List<Professor>>(HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * This method is used to view the students by admin
	 * 
	 * @return List of students
	 */

	@RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET, value = "/viewStudents")
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
	 * This method is used to delete the course using the course code
	 * 
	 * @param courseCode
	 * @return success/failure message
	 * @throws CourseNotFoundException
	 */

	@RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.DELETE, value = "/removeCourse/{courseCode}")
	@ResponseBody
	public ResponseEntity<String> removeCourse(@PathVariable("courseCode") String courseCode) {
		try {
			return new ResponseEntity<String>(adminServiceImpl.removeCourse(courseCode), HttpStatus.OK);
		} catch (CourseNotFoundException e) {
			logger.error("Exception in removeCourse() method in controller" + e.getMessage());
			return new ResponseEntity<String>("Exception in removing : " + courseCode, HttpStatus.NOT_FOUND);

		}
	}

	/**
	 * This method is used to delete the student using the student id
	 * 
	 * @param id
	 * @return success/failure message
	 * @throws StudentNotFoundException
	 */

	@RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.DELETE, value = "/removeStudent/{id}")
	@ResponseBody
	public ResponseEntity<String> removeStudent(@PathVariable("id") String id) {
		try {
			logger.info("Inside AdminController remove student ");
			return new ResponseEntity<String>(adminServiceImpl.removeStudent(id), HttpStatus.OK);
		} catch (StudentNotFoundException e) {
			logger.error("Exception in removeStudent() method in controller" + e.getMessage());
			return new ResponseEntity<String>("Exception in removing : " + id, HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * This method is used to delete the student using the student id
	 * 
	 * @param name
	 * @return success/failure message
	 * @throws ProfessorNotFoundException
	 */

	@RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.DELETE, value = "/removeProfessor/{name}")
	@ResponseBody
	public ResponseEntity<String> removeProfessor(@PathVariable("name") String name) {
		try {
			logger.info("Inside AdminController remove professor ");
			return new ResponseEntity<String>(adminServiceImpl.removeProfessor(name), HttpStatus.OK);
		} catch (ProfessorNotFoundException e) {
			logger.error("Exception in removeProfessor() method in controller" + e.getMessage());
			return new ResponseEntity<String>("Exception in removing : " + name, HttpStatus.NOT_FOUND);
		}
	}

}
