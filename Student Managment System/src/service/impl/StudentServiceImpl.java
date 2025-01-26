package service.impl;

import java.util.List;
import java.util.Objects;

import config.PropertiesConfig;
import dto.StudentDTO;
import exceptions.StudentExists;
import exceptions.StudentNotExists;
import repository.impl.StudentRepositoryImpl;
import service.StudentService;

public class StudentServiceImpl implements StudentService{
	
	private static final String studentExists="student.exists";
	private static final String studentNotExists="student.not.exists";
	private static final PropertiesConfig propertiesConfig=PropertiesConfig.getInstance();
	private StudentRepositoryImpl studentRepository;
	
	public StudentServiceImpl()
	{
		this.studentRepository=new StudentRepositoryImpl();
	}
	@Override
	public void saveStudent(StudentDTO student) throws StudentExists {
		StudentDTO existingStudent=studentRepository.findStudent(student.getStudentId());
		if(Objects.nonNull(existingStudent)) {
			throw new StudentExists(propertiesConfig.getProperty(studentExists)+student.getStudentId());
		} else {
			studentRepository.saveStudent(student);
		}
		
	}
	@Override
	public StudentDTO findStudent(int studentId) throws StudentNotExists {
		StudentDTO existingStudent=studentRepository.findStudent(studentId);
		if(Objects.isNull(existingStudent)) {
			throw new StudentNotExists((propertiesConfig.getProperty(studentNotExists)+studentId));
		} else {
			return existingStudent;
		}
	}
	@Override
	public StudentDTO updateStudent(int studentId, String studentName) throws StudentNotExists {
		StudentDTO existingStudent=studentRepository.findStudent(studentId);
		if(Objects.isNull(existingStudent)) {
			throw new StudentNotExists((propertiesConfig.getProperty(studentNotExists)+studentId));
		} else {
			return studentRepository.updateStudent(studentId, studentName);
		}
	}
	@Override
	public void deleteStudent(int studentId) throws StudentNotExists {
		StudentDTO existingStudent=studentRepository.findStudent(studentId);
		if(Objects.isNull(existingStudent)) {
			throw new StudentNotExists((propertiesConfig.getProperty(studentNotExists)+studentId));
		} else {
			studentRepository.deleteStudent(studentId);
		}
		
	}
	@Override
	public List<StudentDTO> studentRecords() {
		return studentRepository.StudentsRecords();
	}

}
