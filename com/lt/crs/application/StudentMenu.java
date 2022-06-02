/**
 * 
 */
package com.lt.crs.application;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.lt.crs.exception.InvalidPasswordException;
import com.lt.crs.service.StudentService;
import com.lt.crs.service.StudentServiceInterface;

/**
 * @author admin
 *
 */
public class StudentMenu {

	/**
	 * This class is used to authenticate the student login and display the student
	 * menu
	 * 
	 */
	static CRSApplication crsApp = new CRSApplication();

	// This method is written to verify Student username and password
	/**
	 * This method is used to verify student login
	 * 
	 * @param role is will be delegated to the method from Crs application home menu
	 */
	public static void studentLogin(String role) {

		Map<Integer, String> students = (Map<Integer, String>) new HashMap<Integer, String>() {
			{
				put(123, "abc");
				put(124, "xyz");
				put(125, "lmn");

			}
		};

		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter login Id :");

		int LoginId = sc.nextInt();
		System.out.println("Enter Password :");
		String Password = sc.next();
		int counter = 0;

		for (Map.Entry student : students.entrySet()) {
			if (LoginId == (int) student.getKey() && Password.equals(student.getValue())) {

				counter = 1;
				break;

			} else
				counter = 2;
		}

		if (counter == 1) {
			System.out.println("Logged in successfully!");
			LocalDateTime localDateTime = LocalDateTime.now();
			System.out.println("Logged in at:  " + localDateTime);
			studentMainMenu(LoginId);

		}

		else if (counter == 2) {
			// System.out.println( "Incorrect userid or password. Please try again or
			// Register");
			try {
				throw new InvalidPasswordException("Incorrect Password. Please try again.");

			} catch (InvalidPasswordException e) {
				System.out.println(e);
			}
			studentLogin(role);
		}
	}

	/**
	 * This method is used to display student menu
	 * 
	 * @param role is will be delegated to the method from student login method in
	 *             studentmenu class
	 */
	public static void studentMainMenu(int id) {

		System.out.println("Menu");
		System.out.println(
				"1.Register a Course\n2.View GradeCard\n3.View Catalog\n4.Add/Delete Course \n5.Pay Fee\n6.Logout");
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();

		switch (input) {

		case 1:
			StudentServiceInterface ssc = new StudentService();
			ssc.viewCatalog();
			System.out.println("Please select the Course\n");
			int inp = sc.nextInt();
			ssc.registerCourse(inp);
			studentMainMenu(id);
			break;

		case 2:
			StudentServiceInterface ssc1 = new StudentService();
			ssc1.viewreportcard(id);
			studentMainMenu(id);
			break;

		case 3:
			StudentServiceInterface ssc2 = new StudentService();
			ssc2.viewCatalog();
			studentMainMenu(id);
			break;

		case 4:
			StudentServiceInterface ssc3 = new StudentService();
			ssc3.course();
			studentMainMenu(id);
			break;

		case 5:
			StudentServiceInterface ssc4 = new StudentService();
			ssc4.payFee(id);
			studentMainMenu(id);
			break;

		case 6:

			System.out.println("Successfully Logged out.");
			studentLogin(String.valueOf(id));
			break;

		}

	}

}
