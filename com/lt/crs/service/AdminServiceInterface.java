/**
 * 
 */
package com.lt.crs.service;

import com.lt.crs.bean.Admin;

/**
 * @author user219
 * 
 */
public interface AdminServiceInterface {

	public void addProfessor(Admin admin);

	public void approveStudents();

	public void generateReportCard();

	public void addCourse();

	public void removeCourse();
}
