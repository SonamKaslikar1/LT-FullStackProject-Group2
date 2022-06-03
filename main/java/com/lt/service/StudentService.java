package com.lt.service;

import java.util.ArrayList;

import com.lt.dao.StudentDao;
import com.lt.dao.StudentDaoInterface;

public class StudentService implements StudentServiceInterface {
	public void viewStudentDetails() {
		StudentDaoInterface ssd = new StudentDao();

		ssd.viewStudentDetails();
	}

	public void registerCourse(int input) {

		StudentDaoInterface ssd = new StudentDao();
		ssd.registerCourse(input);

		// StudentServiceDao s1=(input)->{ };

	}

	public void viewreportcard(int id) {

		int i = id;
		StudentDaoInterface ssd = new StudentDao();
		ArrayList dataList = (ArrayList) ssd.viewreportcard(i);

		for (int j = 0; j < dataList.size(); j++) {
			System.out.println(j + 1 + "." + dataList.get(j));
		}

	}

	public void viewCatalog() {

		StudentDaoInterface ssd = new StudentDao();
		ArrayList resultlist = (ArrayList) ssd.viewCatalog();

		System.out.println(" Courses:");
		for (int i = 0; i < resultlist.size(); i++) {
			System.out.println(i + 1 + "." + resultlist.get(i));
		}

	}

	public void payFee(int i) {

		int f = i;
		StudentDaoInterface ssd = new StudentDao();
		ssd.viewFee(f);
	}

	@Override
	public void course() {
		// TODO Auto-generated method stub
		StudentDaoInterface ssd = new StudentDao();

		ArrayList a = new ArrayList();
		a = ssd.course();
		// return a;

	}

}
