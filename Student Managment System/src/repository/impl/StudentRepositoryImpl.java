package repository.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import config.DatabaseConfig;
import dto.StudentDTO;
import repository.StudentRepository;
import util.MapperUtil;

public class StudentRepositoryImpl implements StudentRepository{

	@Override
	public void saveStudent(StudentDTO student) {
		String sql="""
					insert into student_details 
					(student_id,student_name,student_gender,student_age,student_admission_date,student_dept,student_email)
					values
					(?, ?, ?, ?, ?, ?, ?)
				""";
		try (Connection connect=DatabaseConfig.getConnection();
				PreparedStatement prestmt=connect.prepareStatement(sql))
		{
			prestmt.setInt(1, student.getStudentId());
			prestmt.setString(2, student.getStudentName());
			prestmt.setString(3, student.getStudentGender().toString());
			prestmt.setInt(4, student.getStudentAge());
			prestmt.setDate(5, Date.valueOf(student.getStudentAdmissionDate()));
			prestmt.setString(6, student.getStudentDeptarment());
			prestmt.setString(7, student.getStudentDeptarment());
			prestmt.executeUpdate();
		} catch(Exception e) { 
			System.out.println("Exception in save "+e);
		}
		
	}

	@Override
	public StudentDTO findStudent(int studentId) {
		String sql="select * from student_details where student_id = ?";
		StudentDTO student=null;
		try (Connection connect=DatabaseConfig.getConnection();
				PreparedStatement prestmt=connect.prepareStatement(sql))
		{
			prestmt.setInt(1, studentId);
			ResultSet results=prestmt.executeQuery();
			while(results.next())
			{
				student=MapperUtil.convertResultSet(results);
			}
		} catch(Exception e) {
			System.out.println("Exception in Finding Student "+e);
		}
		return student;
	}

	@Override
	public StudentDTO updateStudent(int studentId, String studentName) {
		String sql="update student_details set student_name = ? where student_id = ?";
		String selectSql="select * from student_details where student_id = ?";
		StudentDTO student=null;
		try (Connection connect=DatabaseConfig.getConnection();
				PreparedStatement prestmt=connect.prepareStatement(sql))
		{
			prestmt.setString(1, studentName);
			prestmt.setInt(2, studentId);
			prestmt.executeUpdate();
			try (PreparedStatement prestmt1=connect.prepareStatement(selectSql))
			{
				prestmt1.setInt(1, studentId);
				ResultSet results=prestmt1.executeQuery();
				while(results.next())
				{
					student=MapperUtil.convertResultSet(results);
				}
			}
		} catch(Exception e) {
			System.out.println("Error in updating student name "+e);
		}
		return student;
	}

	@Override
	public void deleteStudent(int studentId) {
		String sql="delete from student_details where student_id = ?";
		try (Connection connect=DatabaseConfig.getConnection();
				PreparedStatement prestmt=connect.prepareStatement(sql))
		{
			prestmt.setInt(1, studentId);
			prestmt.executeUpdate();
		} catch(Exception e) {
			System.out.println("Exception in Finding Student "+e);
		}
		
	}

	@Override
	public List<StudentDTO> StudentsRecords() {
		String sql="select * from student_details";
		List<StudentDTO> studentsRecords=new ArrayList<>();
		StudentDTO student=null;
		try (Connection connect=DatabaseConfig.getConnection();
				PreparedStatement prestmt=connect.prepareStatement(sql))
		{
			ResultSet results=prestmt.executeQuery();
			while(results.next())
			{
				student=MapperUtil.convertResultSet(results);
				studentsRecords.add(student);
			}
		} catch(Exception e) {
			System.out.println("Exception in Finding Student ");
		}
		return studentsRecords;
	}

}
