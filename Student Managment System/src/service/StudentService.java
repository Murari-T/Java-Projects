package service;

import java.util.List;

import dto.StudentDTO;
import exceptions.StudentExists;
import exceptions.StudentNotExists;

public interface StudentService {
	
	void saveStudent(StudentDTO  student) throws StudentExists;
	
	StudentDTO findStudent(int studentId) throws StudentNotExists;
	
	StudentDTO updateStudent(int studentId,String studentName) throws StudentNotExists;
	
	void deleteStudent(int studentId) throws StudentNotExists;
	
	List<StudentDTO> studentRecords();

}
