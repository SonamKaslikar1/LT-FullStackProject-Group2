/**
 * 
 */
package com.lt.dao;

import java.util.ArrayList;

/**
 * @author user219
 *
 */
public interface StudentDaoInterface {
	public void viewStudentDetails();

	public void registerCourse(int inp);

	public ArrayList viewreportcard(int i);

	public ArrayList viewCatalog();

	public void payFee();

	public void viewFee(int f);

	public ArrayList course();
}
