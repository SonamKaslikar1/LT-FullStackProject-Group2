/**
 * 
 */
package com.lt.crs.application;

import java.time.LocalDateTime;
import java.util.Scanner;

import com.lt.crs.service.CourseService;
import com.lt.crs.service.ProfessorService;
import com.lt.crs.service.StudentService;

/**
 * @author admin
 *
 */
public class ProfessorMenu {

	/**
	 * @param args
	 */
	// This method is written to verify Professor username and password
	public static void professorLogin() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("ENTER login Id :");
		String LoginId = sc.nextLine();
		System.out.println("ENTER Password :");
		String Password = sc.nextLine();
		if (LoginId.equals("professor") && Password.equals("professor")) {
			professorMainMenu();
		} else {
			System.out.println("Wrong Credentials Please Try Again.\n");
			CRSApplication.home();
		}

	}

	// This method is written to display Professor menu
	private static void professorMainMenu() {
		ProfessorService profService = new ProfessorService();

		System.out.println("Choose from following options:");
		System.out.println("--------------");
		System.out.println("1. View Teaching Courses -->");
		System.out.println("2. View Enrolled Student -->");
		System.out.println("3. Add Grades -->");

		System.out.println("Enter your choice: ");
		Scanner sc = new Scanner(System.in);
		int profOperationChoice2 = sc.nextInt();
		switch (profOperationChoice2) {
		case 1:
			CourseService courseService = new CourseService();
			courseService.listCourses();
			professorMainMenu();
			break;

		case 2:
			StudentService studentService = new StudentService();
			studentService.viewStudentDetails();
			professorMainMenu();
			break;

		case 3:

//		default:
//			System.out.println("No such choices, press 1 or 2");
//
		}
	}

}
