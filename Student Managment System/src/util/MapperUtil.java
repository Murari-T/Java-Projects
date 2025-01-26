package util;

import java.sql.ResultSet;
import java.sql.SQLException;

import dto.StudentDTO;
import enums.Gender;

public class MapperUtil {
	
	private MapperUtil() { }
	
	public static StudentDTO convertResultSet(ResultSet results) throws SQLException
	{
		StudentDTO student=new StudentDTO();
		student.setStudentId(results.getInt("student_id"));
		student.setStudentName(results.getString("student_name"));
		student.setStudentGender(Gender.valueOf(results.getString("student_gender")));
		student.setStudentAge(results.getInt("student_age"));
		student.setStudentAdmissionDate(results.getDate("student_admission_date").toLocalDate());
		student.setStudentDeptarment(results.getString("student_dept"));
		student.setStudentemail(results.getString("student_email"));
		return student;
	}

}
