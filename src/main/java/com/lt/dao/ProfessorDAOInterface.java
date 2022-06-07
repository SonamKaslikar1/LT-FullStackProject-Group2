/**
 * 
 */
package com.lt.dao;

import com.lt.exception.GradeNotWithinRangeException;

/**
 * @author sandeepnani
 *
 */
public interface ProfessorDAOInterface {
	public String addGrades(int sum) throws GradeNotWithinRangeException;

}
