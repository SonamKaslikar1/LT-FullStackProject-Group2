package com.lt.service;

import java.util.List;

import com.lt.dto.Course;
import com.lt.dto.Professor;
import com.lt.dto.Student;
import com.lt.exception.CourseNotFoundException;
import com.lt.exception.ProfessorNotFoundException;
import com.lt.exception.StudentNotFoundException;

public interface AdminService {

	public List<Course> addCourse(List<Course> course);

	public List<Course> veiwCourse();

	public List<Professor> addProfessor(List<Professor> professor);

	public List<Professor> veiwProfessor();

	public List<Student> addStudent(List<Student> student);

	public List<Student> viewStudents();

	public String removeCourse(String courseCode) throws CourseNotFoundException;

	public String removeStudent(String id) throws StudentNotFoundException;

	public String removeProfessor(String name) throws ProfessorNotFoundException;

}
