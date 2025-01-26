package util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;

import dto.StudentDTO;
import enums.Gender;

public class InputUtil {
	
	private InputUtil() { } 
	
	public static int menuOptions(Scanner sc)
	{
		System.out.println("1. To Save new Student Record");
		System.out.println("2. To Find new Student Record");
		System.out.println("3. To Update new Student Record");
		System.out.println("4. To Delete new Student Record");
		System.out.println("5. Retrive All Student Records");
		int menu=sc.nextInt();
		if(menu>=1 && menu<=5) {
			return menu;
		} else {
			return menuOptions(sc);
		}
	}
	
	public static boolean wantToContinue(Scanner sc)
	{
		System.out.println("Do you want to continue (Y|N)");
		char choice=sc.next().toUpperCase().charAt(0);
		return 'Y' == choice;
	}
	
	public static StudentDTO acceptStudentDetails(Scanner sc)
	{
		System.out.println("Enter Student Id");
		int studentId=sc.nextInt();
		System.out.println("Enter Student Name");
		String studentName=sc.next();
		System.out.println("Enter Student Gender : "+Arrays.asList(Gender.values()).toString());
		String studentGender=sc.next().toUpperCase();
		System.out.println("Enter Student Age ");
		int studentAge=sc.nextInt();
		System.out.println("Enter Student Addmission Date (dd-mm-yyyy)");
		String studentAddmissiondate=sc.next();
		System.out.println("Enter Student Department");
		String studentDepartment=sc.next();
		System.out.println("Enter Student Email");
		String studentEmail=sc.next();
		try 
		{
			StudentDTO student=new StudentDTO();
			student.setStudentId(studentId);
			student.setStudentName(studentName);
			student.setStudentGender(Gender.valueOf(studentGender));
			student.setStudentAge(studentAge);
			student.setStudentAdmissionDate(convertLocalDate(studentAddmissiondate));
			student.setStudentDeptarment(studentDepartment);
			student.setStudentemail(studentEmail);
			return student;
		} catch (Exception e) {
			System.out.println("Error in Accept Student Details");
			return acceptStudentDetails(sc);
		}
	}

	public static LocalDate convertLocalDate(String studentAddmissiondate) {
		DateTimeFormatter format=DateTimeFormatter.ofPattern("dd-MM-yyyy");
		return LocalDate.parse(studentAddmissiondate,format);
	}
	
	public static int operateById(Scanner sc)
	{
		System.out.println("Enter Id");
		return sc.nextInt();
	}
	
	public static String toUpdateStudentName(Scanner sc)
	{
		System.out.println("Enter Student Name ");
		return sc.next();
	}
}
