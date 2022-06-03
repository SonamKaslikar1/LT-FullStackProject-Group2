package com.lt.application;

import java.time.LocalDateTime;
import java.util.Formatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.lt.bean.Admin;
import com.lt.bean.Course;
import com.lt.configuration.AdminConfig;
import com.lt.configuration.AppConfig;
import com.lt.configuration.ProfessorConfig;
import com.lt.configuration.StudentConfig;
import com.lt.exception.CourseNotFoundException;
import com.lt.exception.GradeNotWithinRangeException;
import com.lt.exception.InvalidPasswordException;
import com.lt.service.AdminService;
import com.lt.service.CourseService;
import com.lt.service.ProfessorService;
import com.lt.service.StudentService;

/**
 * This file is the entry point for the application and representing by the
 * annotation @SpringBootApplication which tells the spring container that it is
 * a entry point for the project
 * 
 * springapplication.run() will execute and the spring boot application will get
 * up.
 *
 */
@SpringBootApplication
@Configuration
@ComponentScan({ "com.lt.*" })
@EnableAutoConfiguration
@Import({ AdminConfig.class, StudentConfig.class, ProfessorConfig.class })
public class DemoCoreSpringApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// using the applicationContext which is a sub interface of bean factory, start
		// the spring application.

		ApplicationContext context = SpringApplication.run(AppConfig.class);

		AdminService adminService = (AdminService) context.getBean("adminBean");

		StudentService ssc = (StudentService) context.getBean("studentBean");

		ProfessorService profService = (ProfessorService) context.getBean("professorBean");

		CourseService courseService = (CourseService) context.getBean("courseBean");

		System.out.println("\n=== WELCOME TO CRS APPLICATION === \n");

		home(adminService, ssc, profService, courseService);

	}

	/**
	 * This is the home method for displaying the CRS Application home page. this
	 * will take the user option based on the option related task will get executed
	 * 
	 * @param adminService
	 * @param ssc
	 * @param profService
	 * @param courseService
	 */
	public static void home(AdminService adminService, StudentService ssc, ProfessorService profService,
			CourseService courseService) {
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
			loginUserRole(adminService, ssc, profService, courseService);
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

	/**
	 * This is the login user role method used for redirecting the CRS Application
	 * login page to related roles classes based on user input. this will take the
	 * user input of the role based on the input related page will get redirected
	 * 
	 * @param adminService
	 * @param ssc
	 * @param profService
	 * @param courseService
	 */
	public static void loginUserRole(AdminService adminService, StudentService ssc, ProfessorService profService,
			CourseService courseService) {
		Scanner sc = new Scanner(System.in);
		System.out.println("ENTER Role :");
		String role = sc.nextLine();
		if (role != null && role.equals("admin")) {
			adminLogin(adminService, ssc, profService, courseService);
		} else if (role != null && role.equals("student")) {
			studentLogin("student", adminService, ssc, profService, courseService);

		} else if (role != null && role.equals("professor")) {
			professorLogin(adminService, ssc, profService, courseService);

		} else {
			System.out.println("Please enter a valid Role.\n");
			home(adminService, ssc, profService, courseService);
		}
	}

	/**
	 * This method is used to authenticate the admin login authencation is success
	 * then it will redirect to admin menu
	 * 
	 * @param adminService
	 * @param ssc
	 * @param profService
	 * @param courseService
	 */
	public static void adminLogin(AdminService adminService, StudentService ssc, ProfessorService profService,
			CourseService courseService) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("ENTER login Id :");
		String LoginId = sc.nextLine();
		System.out.println("ENTER Password :");
		String Password = sc.nextLine();
		if (LoginId.equals("admin") && Password.equals("admin")) {
			adminMainMenu(adminService, ssc, profService, courseService);
		} else {
			System.out.println("Wrong Credentials Please Try Again.\n");
			home(adminService, ssc, profService, courseService);
		}

	}

	/**
	 * This method is used to display Admin menu user input will be taken to take
	 * action on the menu displayed
	 * 
	 * @param adminService
	 * @param ssc
	 * @param profService
	 * @param courseService
	 */
	public static void adminMainMenu(AdminService adminService, StudentService ssc, ProfessorService profService,
			CourseService courseService) {

		Scanner sc = new Scanner(System.in);
		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println("Welcome Admin ");
		System.out.println("Admin logged in successfully  : " + localDateTime);

		System.out.println("\n1. Add Course");
		System.out.println("2. Remove Course");
		System.out.println("3. Add Professor");
		System.out.println("4. Approve Student Registration");
		System.out.println("5. Generate Report Card");
		System.out.println("6. Exit \n");

		System.out.println("select an Option :");
		int option = sc.nextInt();
		switch (option) {
		case 1:
			addCourse(adminService, ssc, profService, courseService);
			break;
		case 2:
			removeCourse(adminService, ssc, profService, courseService);
			break;
		case 3:
			addProfessor(adminService, ssc, profService, courseService);
			break;
		case 4:
			approveStudentRegistration(adminService, ssc, profService, courseService);
			break;
		case 5:
			try {
				generateReportCard(adminService, ssc, profService, courseService);
			} catch (GradeNotWithinRangeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 6:
			home(adminService, ssc, profService, courseService);
			break;
		default:
			home(adminService, ssc, profService, courseService);

		}

	}

	/**
	 * This method is used to add the course for admin already available courses
	 * will get displayed here user input will be taken to add the course
	 * 
	 * @param adminService
	 * @param ssc
	 * @param profService
	 * @param courseService
	 */
	public static void addCourse(AdminService adminService, StudentService ssc, ProfessorService profService,
			CourseService courseService) {
		List<Course> newcourseList = null;
		// TODO Auto-generated method stub
		System.out.println("Currently Available Courses: \n");
		List<Course> courseList = adminService.viewCourseDetails();

		Formatter fmt = new Formatter();
		System.out.println("-----------------------------------------------------------------------------");

		System.out.println(fmt.format("%15s %15s %15s\n", "COURSE CODE", "NAME", "INSTRUCTOR"));
		System.out.println("-----------------------------------------------------------------------------");

		courseList.forEach(System.out::print);
		System.out.println("\n1.Add Course");
		System.out.println("2.Admin Main Menu");
		Scanner sc = new Scanner(System.in);
		int option = Integer.parseInt(sc.nextLine());
		switch (option) {
		case 1:
			System.out.print("Enter the Course Code to Add:");
			String CourseCd = sc.nextLine();
			System.out.print("Enter the Course Name to Add:");
			String CourseName = sc.nextLine();
			System.out.print("Enter the instructor name:");
			String instructor = sc.nextLine();

			if (CourseName != "" && CourseName != null && CourseCd != "" && CourseCd != null && instructor != ""
					&& instructor != null) {
				Course course = new Course();
				course.setCourseCode(CourseCd);
				course.setName(CourseName);
				course.setOffered(true);
				course.setInstructor(instructor);

				newcourseList = adminService.addCourse(course);
			}
			System.out.println("Course Added sucessfully");

			System.out.println("\n Courses available after adding the course \n");
			System.out.println("-----------------------------------------------------------------------------");

			System.out.println(fmt.toString());
			System.out.println("-----------------------------------------------------------------------------");

			newcourseList.forEach(name -> System.out.print(name));
			System.out.println();
			adminMainMenu(adminService, ssc, profService, courseService);
			break;
		case 2:
			adminMainMenu(adminService, ssc, profService, courseService);
			;

		}

	}

	/**
	 * This method is used to delete the course for admin already available courses
	 * will get displayed here user input will be taken to delete the course
	 * 
	 * @param adminService
	 * @param ssc
	 * @param profService
	 * @param courseService
	 */
	public static void removeCourse(AdminService adminService, StudentService ssc, ProfessorService profService,
			CourseService courseService) {
		try {
			// TODO Auto-generated method stub
			List<Course> newcourseList = null;
			System.out.println("Currently Available Courses: ");
			List<Course> courseList = adminService.viewCourseDetails();

			Formatter fmt = new Formatter();
			System.out.println("-----------------------------------------------------------------------------");

			System.out.println(fmt.format("%15s %15s %15s\n", "COURSE CODE", "NAME", "INSTRUCTOR"));
			System.out.println("-----------------------------------------------------------------------------");

			courseList.forEach(System.out::print);

			System.out.println("\n1.Remove Course");
			System.out.println("2.Admin Main Menu");
			Scanner sc = new Scanner(System.in);
			int option = Integer.parseInt(sc.nextLine());
			switch (option) {
			case 1:
				System.out.print("Enter the CourseName to Remove:");
				String CourseName = sc.nextLine();

				if (CourseName != "" && CourseName != null) {
					newcourseList = adminService.deleteCourse(CourseName);
				}
				System.out.println("Course Removed sucessfully");

				System.out.println("\n Courses avaible after Removing the course \n");
				System.out.println("-----------------------------------------------------------------------------");

				System.out.println(fmt.toString());
				System.out.println("-----------------------------------------------------------------------------");

				newcourseList.forEach(name -> System.out.print(name));

				System.out.println();
				adminMainMenu(adminService, ssc, profService, courseService);
				break;
			case 2:
				adminMainMenu(adminService, ssc, profService, courseService);
				;

			}
		} catch (CourseNotFoundException ex) {
			System.out.println("Caught the exception");

			// printing the message from InvalidAgeException object
			System.out.println("Exception occured: " + ex);
		} finally {
			adminMainMenu(adminService, ssc, profService, courseService);
		}
	}

	/**
	 * This method is used to add the professor for admin user input will be taken
	 * to add the department user input will be taken to add the designation
	 * 
	 * @param adminService
	 * @param ssc
	 * @param profService
	 * @param courseService
	 */
	public static void addProfessor(AdminService adminService, StudentService ssc, ProfessorService profService,
			CourseService courseService) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Department :");
		String department = sc.nextLine();
		System.out.println("Enter Designation :");
		String designation = sc.nextLine();
		Admin admin = new Admin();
		admin.setDepartment(department);
		admin.setDesignation(designation);
		adminService.addProfessor(admin);
		adminMainMenu(adminService, ssc, profService, courseService);
	}

	/**
	 * This method is used to add the approve student registration for admin user
	 * input will be taken to approve the registered courses
	 * 
	 * @param adminService
	 * @param ssc
	 * @param profService
	 * @param courseService
	 */
	public static void approveStudentRegistration(AdminService adminService, StudentService ssc,
			ProfessorService profService, CourseService courseService) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		System.out.println("Please select the Student Id to register for the course.\n");

		int inp = sc.nextInt();

		if (inp == 1 || inp == 2 || inp == 3 || inp == 4) {
			adminService.approveStudents(inp);
			adminMainMenu(adminService, ssc, profService, courseService);
		} else {
			System.out.println("Cannot register to this course under this course.");
		}

	}

	/**
	 * This method is used to generate report of student based on their marks user
	 * input will be taken to generate the report
	 * 
	 * @param adminService
	 * @param ssc
	 * @param profService
	 * @param courseService
	 * @throws GradeNotWithinRangeException
	 */

	public static void generateReportCard(AdminService adminService, StudentService ssc, ProfessorService profService,
			CourseService courseService) throws GradeNotWithinRangeException {
		try {
			// TODO Auto-generated method stub
			Scanner sc = new Scanner(System.in);
			System.out.println("Please select the Student Id to generate report card.\n");
			int studentId = sc.nextInt();
			System.out.println("Enter the marks for below courses.\n");
			System.out.println("1.Physics\n2.Chemistry\n3.Maths\n4.English");
			int sum = 0;

			int[] marks = new int[4];
			for (int i = 0; i < 4; i++) {
				marks[i] = sc.nextInt();
				sum = sum + marks[i];
			}
//			AdminServiceInterface adminService = new AdminService();
			adminService.generateReportCard(studentId, sum);
		} catch (GradeNotWithinRangeException ex) {
			System.out.println("Caught the exception");

			// printing the message from GradeNotWithinRangeException object
			System.out.println("Exception occured: " + ex);
		} finally {
			adminMainMenu(adminService, ssc, profService, courseService);
		}
	}

	/**
	 * This method is used to verify student login
	 * 
	 * @param role          is will be delegated to the method from Crs application
	 *                      home menu
	 * @param adminService
	 * @param ssc
	 * @param profService
	 * @param courseService
	 */

	public static void studentLogin(String role, AdminService adminService, StudentService ssc,
			ProfessorService profService, CourseService courseService) {

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
			studentMainMenu(LoginId, adminService, ssc, profService, courseService);

		}

		else if (counter == 2) {
			// System.out.println( "Incorrect userid or password. Please try again or
			// Register");
			try {
				throw new InvalidPasswordException("Incorrect Password. Please try again.");

			} catch (InvalidPasswordException e) {
				System.out.println(e);
			}
			studentLogin(role, adminService, ssc, profService, courseService);
		}
	}

	/**
	 * This method is used to display student menu
	 * 
	 * @param id
	 * @param adminService
	 * @param ssc
	 * @param profService
	 * @param courseService
	 */

	public static void studentMainMenu(int id, AdminService adminService, StudentService ssc,
			ProfessorService profService, CourseService courseService) {

		System.out.println("Menu");
		System.out.println(
				"1.Register a Course\n2.View GradeCard\n3.View Catalog\n4.Add/Delete Course \n5.Pay Fee\n6.Logout");
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();

		switch (input) {

		case 1:
			ssc.viewCatalog();
			System.out.println("Please select the Course\n");
			int inp = sc.nextInt();
			ssc.registerCourse(inp);
			studentMainMenu(id, adminService, ssc, profService, courseService);
			break;

		case 2:
			ssc.viewreportcard(id);
			studentMainMenu(id, adminService, ssc, profService, courseService);
			break;

		case 3:
			ssc.viewCatalog();
			studentMainMenu(id, adminService, ssc, profService, courseService);
			break;

		case 4:
			ssc.course();
			studentMainMenu(id, adminService, ssc, profService, courseService);
			break;

		case 5:
			ssc.payFee(id);
			studentMainMenu(id, adminService, ssc, profService, courseService);
			break;

		case 6:

			System.out.println("Successfully Logged out.");
			studentLogin(String.valueOf(id), adminService, ssc, profService, courseService);
			break;

		}

	}

	/**
	 * This method is written to display username and password for professor login
	 * 
	 * @param adminService
	 * @param ssc
	 * @param profService
	 * @param courseService
	 */

	public static void professorLogin(AdminService adminService, StudentService ssc, ProfessorService profService,
			CourseService courseService) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("ENTER login Id :");
		String LoginId = sc.nextLine();
		System.out.println("ENTER Password :");
		String Password = sc.nextLine();
		if (LoginId.equals("professor") && Password.equals("professor")) {
			professorMainMenu(adminService, ssc, profService, courseService);
		} else {
			System.out.println("Wrong Credentials Please Try Again.\n");
			home(adminService, ssc, profService, courseService);
		}

	}

	/**
	 * This method is written to display Professor menu
	 * 
	 * @param adminService
	 * @param ssc
	 * @param profService
	 * @param courseService
	 */
	private static void professorMainMenu(AdminService adminService, StudentService ssc, ProfessorService profService,
			CourseService courseService) {

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
			courseService.listCourses();
			professorMainMenu(adminService, ssc, profService, courseService);
			break;

		case 2:
			StudentService studentService = new StudentService();
			studentService.viewStudentDetails();
			professorMainMenu(adminService, ssc, profService, courseService);
			break;

		case 3:

//		default:
//			System.out.println("No such choices, press 1 or 2");
//
		}
	}

}
