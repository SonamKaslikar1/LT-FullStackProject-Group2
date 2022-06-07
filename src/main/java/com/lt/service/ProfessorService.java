/**
 * 
 */
package com.lt.service;

import com.lt.exception.GradeNotWithinRangeException;

/**
 * @author sandeepnani
 *
 */
public interface ProfessorService {

	public String addGrades(int sum) throws GradeNotWithinRangeException;
}
