package com.lt.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lt.configuration.JDBCConfiguration;
import com.lt.constants.JDBCTemplateConstants;
import com.lt.constants.RoleConstants;
import com.lt.dto.Course;
import com.lt.dto.Employee;
import com.lt.dto.Professor;
import com.lt.dto.Student;
import com.lt.exception.CourseNotFoundException;
import com.lt.exception.ProfessorNotFoundException;
import com.lt.exception.StudentNotFoundException;
import com.lt.mapper.CourseMapper;
import com.lt.mapper.EmployeeMapper;
import com.lt.mapper.ProfessorMapper;
import com.lt.mapper.StudentMapper;
import com.lt.rest.AdminController;

/**
 * 
 * @author admin
 *
 */
@Repository
public class AdminDAO implements AdminDAOInterface {

	@Autowired
	JDBCConfiguration jdbcConfiguration;
	
	@Autowired
	JDBCTemplateConstants jdbcTemplateConstants;
	@Autowired
	RoleConstants roleConstants;

	private static final Logger logger = LoggerFactory.getLogger(AdminDAO.class);

	/**
	 * this method is used to add the courses by admin 
	 * List of courses will be taken as parameter to add in database
	 */
	@Override
	@Transactional
	public List<Course> addCourse(List<Course> course) {
		// TODO Auto-generated method stub

		for (Course c : course) {
			jdbcConfiguration.jdbcTemplate().update(jdbcTemplateConstants.addCourseSQL, c.getCourseCode(), c.getCourseName(), c.getIsOffered(),
					c.getInstructor());
		}
		List<Course> courseList = veiwCourse();
		logger.info("course List after adding course is :" + courseList.toString());
		return courseList;
	}

	/**
	 * this method is used to view the courses by admin 
	 * return the list of available courses
	 */
	@Override
	@Transactional
	public List<Course> veiwCourse() {
		// TODO Auto-generated method stub
		List<Course> courseList = jdbcConfiguration.jdbcTemplate().query(jdbcTemplateConstants.viewCourseSQL, new CourseMapper());
		return courseList;
	}


	/**
	 * this method is used to add the professors by admin 
	 * List of professors will be taken as parameter to add in database
	 */
	@Override
	@Transactional
	public List<Professor> addProfessor(List<Professor> professor) {
		// TODO Auto-generated method stub
		for (Professor p : professor) {
			jdbcConfiguration.jdbcTemplate().update(jdbcTemplateConstants.addProfessorSQL, p.getProfName(), p.getDepartment(), p.getDesignation(), roleConstants.professorRoleId);
		}
		List<Professor> professorList = veiwProfessor();
		logger.info("Professor List after adding professor is :" + professorList.toString());
		return professorList;
	}

	
	/**
	 * this method is used to add the student by admin 
	 * List of students will be taken as parameter to add in database
	 */
	@Override
	@Transactional
	public List<Student> addStudent(List<Student> student) {
		// TODO Auto-generated method stub
		

		for (Student s : student) {
			jdbcConfiguration.jdbcTemplate().update(jdbcTemplateConstants.addStudentSQL, s.getName(), roleConstants.studentRoleId);
		}
		List<Student> studentList = viewStudents();
		logger.info("Student List after adding student is :" + studentList.toString());
		return studentList;
	}

	/**
	 * this method is used to view the students by admin 
	 * return the list of available students
	 */
	@Override
	@Transactional
	public List<Student> viewStudents() {
		// TODO Auto-generated method stub
		
		List<Student> studentList = jdbcConfiguration.jdbcTemplate().query(jdbcTemplateConstants.viewStudentSQL, new StudentMapper());
		return studentList;
	}

	/**
	 * this method is used to view the professor by admin 
	 * return the list of available professors
	 */
	@Override
	@Transactional
	public List<Professor> veiwProfessor() {
		// TODO Auto-generated method stub
		
		List<Professor> professorList = jdbcConfiguration.jdbcTemplate().query(jdbcTemplateConstants.viewProfessorSQL, new ProfessorMapper());
		return professorList;
	}

	/**
	 * this method is used to remove the course by admin 
	 * coursecode is taken as a input parameter
	 */
	@Override
	@Transactional
	public String removeCourse(String courseCode) throws CourseNotFoundException {
		List<Course> courseList = veiwCourse();
		List<Course> clist = courseList.stream().filter(n -> n.getCourseCode().equals(courseCode))
				.collect(Collectors.toList());
		if (clist.size() != 0) {
			
			jdbcConfiguration.jdbcTemplate().update(jdbcTemplateConstants.deleteCourseSQL, courseCode);
			logger.info("Course List after removing course is  :" + courseList.toString());
			return "Removed Succesfully";
		} else {
			logger.error("Exception in Removing course code" + courseCode);
			throw new CourseNotFoundException("Exception in Removing course code" + courseCode);
		}

	}

	/**
	 * this method is used to remove the student by admin 
	 * student id is taken as a input parameter
	 */
	@Override
	@Transactional
	public String removeStudent(String id) throws StudentNotFoundException {
		List<Student> studentList = viewStudents();
		List<Student> slist = studentList.stream().filter(n -> n.getId().equals(id)).collect(Collectors.toList());
		if (slist.size() != 0) {
			
			jdbcConfiguration.jdbcTemplate().update(jdbcTemplateConstants.deleteStudentSQL, id);
			logger.info("Student List after removing student is  :" + studentList.toString());
			return "Removed Succesfully";
		} else {
			logger.error("Exception in Removing student Id : " + id);
			throw new StudentNotFoundException("Exception in Removing student Id :" + id);
		}
	}

	/**
	 * this method is used to remove the professor by admin 
	 * professorname is taken as a input parameter
	 */
	@Override
	@Transactional
	public String removeProfessor(String name) throws ProfessorNotFoundException {
		List<Professor> professorList = veiwProfessor();
		List<Professor> plist = professorList.stream().filter(n -> n.getProfName().equals(name))
				.collect(Collectors.toList());
		if(plist.size() != 0) {
		
		jdbcConfiguration.jdbcTemplate().update(jdbcTemplateConstants.deleteProfessorSQL, name);
		logger.info("Professor List after removing professor is  :" + professorList.toString());
		return "Removed Succesfully";
		}
		else {
			logger.error("Exception in Removing Professor name :" + name);
			throw new ProfessorNotFoundException("Exception in Removing Professor name :" + name);
		}
	}

}
