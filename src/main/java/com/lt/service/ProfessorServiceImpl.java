package com.lt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lt.dao.ProfessorDAO;
import com.lt.exception.GradeNotWithinRangeException;

@Service
public class ProfessorServiceImpl implements ProfessorService {

	@Autowired
	ProfessorDAO professorDAO;

	@Override
	public String addGrades(int sum) throws GradeNotWithinRangeException {
		// TODO Auto-generated method stub
		return professorDAO.addGrades(sum);
	}

}
