package it.red;

import java.sql.Date;

public class Student {
	private int id_student;
	private String personal_email;
	private String institutional_email;
	private String first_name;
	private String last_name;
	private String phone_number;
	private Date date_of_birth;
	private String password;
	
	
	public Student(int id_student, String personal_email, String institutional_email, String first_name, String last_name, String phone_number, Date date_of_birth, String password) {
		this.id_student = id_student;
		this.personal_email = personal_email;
		this.institutional_email = institutional_email;
		this.first_name = first_name;
		this.last_name = last_name;
		this.phone_number = phone_number;
		this.date_of_birth = date_of_birth;
		this.password = password;
	}
	
	public int getId_student() {
		return id_student;
	}
	
	public void setId_student(int id_student) {
		this.id_student = id_student;
	}
	
	public String getPersonal_email() {
		return personal_email;
	}
	
	public void setPersonal_email(String personal_email) {
		this.personal_email = personal_email;
	}
	
	public String getInstitutional_email() {
		return institutional_email;
	}
	
	public void setInstitutional_email(String institutional_email) {
		this.institutional_email = institutional_email;
	}
	
	public String getName() {
		return first_name;
	}
	
	public void setName(String name) {
		this.first_name = name;
	}
	
	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	
	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	
	public Date getDate_of_birth() {
		return date_of_birth;
	}
	
	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}	
}
