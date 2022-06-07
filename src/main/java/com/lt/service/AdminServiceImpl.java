package com.lt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lt.dto.Course;
import com.lt.dto.Professor;
import com.lt.dto.Student;
import com.lt.dao.AdminDAO;
import com.lt.dao.AdminDAOInterface;
import com.lt.exception.CourseNotFoundException;
import com.lt.exception.ProfessorNotFoundException;
import com.lt.exception.StudentNotFoundException;
import com.lt.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminDAOInterface adminDAOInterface;

	@Override
	public List<Course> addCourse(List<Course> course) {

		return adminDAOInterface.addCourse(course);
	}

	@Override
	public List<Course> veiwCourse() {
		// TODO Auto-generated method stub
		return adminDAOInterface.veiwCourse();
	}

	@Override
	public List<Professor> addProfessor(List<Professor> professor) {
		// TODO Auto-generated method stub
		return adminDAOInterface.addProfessor(professor);
	}

	@Override
	public List<Student> addStudent(List<Student> student) {
		// TODO Auto-generated method stub
		return adminDAOInterface.addStudent(student);
	}

	@Override
	public List<Student> viewStudents() {
		// TODO Auto-generated method stub
		return adminDAOInterface.viewStudents();
	}

	@Override
	public List<Professor> veiwProfessor() {
		// TODO Auto-generated method stub
		return adminDAOInterface.veiwProfessor();
	}

	@Override
	public String removeCourse(String courseCode) throws CourseNotFoundException {
		// TODO Auto-generated method stub
		return adminDAOInterface.removeCourse(courseCode);
	}

	@Override
	public String removeStudent(String id) throws StudentNotFoundException{
		// TODO Auto-generated method stub
		return adminDAOInterface.removeStudent(id);
	}

	@Override
	public String removeProfessor(String name) throws ProfessorNotFoundException{
		// TODO Auto-generated method stub
		return adminDAOInterface.removeProfessor(name);
	}

}
