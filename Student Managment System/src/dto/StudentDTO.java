package dto;

import java.time.LocalDate;

import enums.Gender;

public class StudentDTO {
	
	private int studentId;
	private String studentName;
	private Gender studentGender;
	private int studentAge;
	private LocalDate studentAdmissionDate;
	private String studentDeptarment;
	private String studentemail;
	
	//getters && setters
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public Gender getStudentGender() {
		return studentGender;
	}
	public void setStudentGender(Gender studentGender) {
		this.studentGender = studentGender;
	}
	public int getStudentAge() {
		return studentAge;
	}
	public void setStudentAge(int studentAge) {
		this.studentAge = studentAge;
	}
	public LocalDate getStudentAdmissionDate() {
		return studentAdmissionDate;
	}
	public void setStudentAdmissionDate(LocalDate studentAdmissionDate) {
		this.studentAdmissionDate = studentAdmissionDate;
	}
	public String getStudentDeptarment() {
		return studentDeptarment;
	}
	public void setStudentDeptarment(String studentDeptarment) {
		this.studentDeptarment = studentDeptarment;
	}
	public String getStudentemail() {
		return studentemail;
	}
	public void setStudentemail(String studentemail) {
		this.studentemail = studentemail;
	}
	
	//to string
	@Override
	public String toString() {
		return "StudentDTO [studentId=" + studentId + ", studentName=" + studentName + ", studentGender="
				+ studentGender + ", studentAge=" + studentAge + ", studentAdmissionDate=" + studentAdmissionDate
				+ ", studentDeptarment=" + studentDeptarment + ", studentemail=" + studentemail + "]";
	}
}
