package repository;

import java.util.List;

import dto.StudentDTO;

public interface StudentRepository {
	
	void saveStudent(StudentDTO student);
	
	StudentDTO findStudent(int studentId);
	
	StudentDTO updateStudent(int studentId,String studentName);
	
	void deleteStudent(int studentId);
	
	List<StudentDTO> StudentsRecords();

}
