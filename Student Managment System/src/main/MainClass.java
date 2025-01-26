package main;

import java.util.List;
import java.util.Scanner;

import dto.StudentDTO;
import service.StudentService;
import service.impl.StudentServiceImpl;
import util.InputUtil;

public class MainClass {
	private StudentService studentService;

	public static void main(String[] args) {
		MainClass macl=new MainClass();
		macl.run();
	}

	public void run()
	{
		studentService=new StudentServiceImpl();
		try (Scanner sc=new Scanner(System.in))
		{
			do
			{
				try
				{
					int menu=InputUtil.menuOptions(sc);
					switch(menu)
					{
					case 1:
						StudentDTO student=InputUtil.acceptStudentDetails(sc);
						studentService.saveStudent(student);
						System.out.println("\nStudent saved\n");
						System.out.println(student);
						break;
					case 2:
						int studentId=InputUtil.operateById(sc);
						student=studentService.findStudent(studentId);
						System.out.println("\nStudent Recorded Fecthed\n");
						System.out.println(student);
						break;
					case 3:
						studentId=InputUtil.operateById(sc);
						String studentName=InputUtil.toUpdateStudentName(sc);
						student=studentService.updateStudent(studentId, studentName);
						System.out.println("\nstudent Record Updated\n");
						break;
					case 4:
						studentId=InputUtil.operateById(sc);
						studentService.deleteStudent(studentId);
						System.out.println("\nstudent Record Deleted\n");
						break;
					case 5:
						List<StudentDTO> studentsRecords=studentService.studentRecords();
						studentsRecords.forEach(System.out::println);
						System.out.println("\nAll Students Records Fecthed\n");
						break;
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}while(InputUtil.wantToContinue(sc));
			System.out.println("Records Modifed in database");
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
