package com.lt.crs.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.lt.crs.bean.Admin;
import com.lt.crs.bean.Course;
import com.lt.crs.service.AdminService;
import com.lt.crs.service.AdminServiceInterface;
import com.lt.crs.service.CatalogService;
import com.lt.crs.service.CatalogServiceInterface;
import com.lt.crs.service.StudentService;
import com.lt.crs.service.StudentServiceInterface;

/**
 * This is the main page for the CRS Application. 
 * main method is present in this class
 * Home() is the method which contains the Login page of Application
 */
public class CRSApplication {

	public static void main(String args[]) {
		System.out.println("=== WELCOME TO CRS APPLICATION === \n");

		home();

	}

	/**
	 * This is the home method for displaying the CRS Application home page. this
	 * will take the user option based on the option related task will get executed
	 */
	public static void home() {
		Scanner sc = new Scanner(System.in);
		System.out.println("1.Login");
		System.out.println("2.New Registration");
		System.out.println("3.Change Password");
		System.out.println("4.Exit \n");

		System.out.println("Choose an Option:--");
		int option = sc.nextInt();
		// switch operation
		switch (option) {
		case 1:
			loginUserRole();
			break;
		case 2:
			// new registration
			break;
		case 3:
			// change password
			break;
		case 4:
			// exit
			;
		}
	}

	// This method is written to verify the role of user logging in as student,
	// professor or admin

	/**
	 * This is the login user role method used for redirecting the CRS Application
	 * login page to related roles classes based on user input. this will take the
	 * user input of the role based on the input related page will get redirected
	 */
	public static void loginUserRole() {
		Scanner sc = new Scanner(System.in);
		System.out.println("ENTER Role :");
		String role = sc.nextLine();
		if (role != null && role.equals("admin")) {
			AdminMenu.adminLogin();
		} else if (role != null && role.equals("student")) {
			StudentMenu.studentLogin("student");

		} else if (role != null && role.equals("professor")) {
			ProfessorMenu.professorLogin();

		} else {
			System.out.println("Please enter a valid Role.\n");
			home();
		}
	}

}