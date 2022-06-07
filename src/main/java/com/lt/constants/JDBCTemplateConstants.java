/**
 * 
 */
package com.lt.constants;

import org.springframework.stereotype.Component;

/**
 * @author sandeepnani
 *
 */
@Component
public class JDBCTemplateConstants {
	
	public String addCourseSQL = "insert into course (courseCode,courseName,isOffered, professorName) values (?, ?,?,?)";
	
	public String viewCourseSQL = "select * from course";
	
	public String addProfessorSQL = "insert into professor (professorName,department, designation,roleId) values (?, ?,?,?)";
	
	public String addStudentSQL = "insert into student (studentName,roleId) values (?,?)";
	
	public String viewStudentSQL = "select * from student";
    
	public String viewProfessorSQL = "select * from professor";
	
	public String deleteCourseSQL = "delete from course where courseCode = ?";
	
	public String deleteStudentSQL = "delete from student where studentId = ?";
	
	public String deleteProfessorSQL = "delete from professor where professorName = ?";
	
	public String gradeSQL = "insert into grade (marks,grade) values (?,?)";
	
	public String loginCheckSQL = "select * from login";
}
