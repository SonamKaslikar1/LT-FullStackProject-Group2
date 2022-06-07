package com.lt.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lt.configuration.JDBCConfiguration;
import com.lt.constants.JDBCTemplateConstants;
import com.lt.exception.GradeNotWithinRangeException;

/**
 * 
 * @author sandeepnani
 *
 */
@Repository
public class ProfessorDAO implements ProfessorDAOInterface {

	private static final Logger logger = LoggerFactory.getLogger(AdminDAO.class);

	@Autowired
	JDBCConfiguration jdbcConfiguration;
    @Autowired
    JDBCTemplateConstants jdbcTemplateConstants;
    /**
     * 
     */
	@Override
	@Transactional
	public String addGrades(int sum) throws GradeNotWithinRangeException {
		String grade = "";
		String flag = "";
		int mean = sum / 4;
		if (mean >= 80) {
			grade = "A";
		} else if (mean < 80 && mean >= 60) {
			grade = "B";
		} else if (mean < 60 && mean >= 40) {
			grade = "C";
		} else {
			grade = "D";
		}
		if (mean < 100) {
			
			jdbcConfiguration.jdbcTemplate().update(jdbcTemplateConstants.gradeSQL, sum, grade);
			logger.info("Grade is inserted  :" + grade);
			flag = "SUCCESS";

		} else {
			logger.error("Exception in inserting grade in table");
			flag = "FAILED";
			throw new GradeNotWithinRangeException("Grade is not within the range of 100.");

		}
		return flag;
	}

}
