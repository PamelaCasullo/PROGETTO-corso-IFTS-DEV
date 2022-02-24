package it.rizzoli.RED.Database;

import java.sql.Date;

public class StudentBean {
	protected int id_student;
	protected String personal_email;
	protected String institutional_email;
	protected String first_name;
	protected String last_name;
	protected String phone_number;
	protected Date date_of_birth;
	protected String password;
	protected String photo;
	
public StudentBean() {
		
	}
	
	public StudentBean(int id_student, String personal_email, String institutional_email, String first_name, String last_name, String phone_number, Date date_of_birth, String password,String photo) {
		this.id_student = id_student;
		this.personal_email = personal_email;
		this.institutional_email = institutional_email;
		this.first_name = first_name;
		this.last_name = last_name;
		this.phone_number = phone_number;
		this.date_of_birth = date_of_birth;
		this.password = password;
		this.photo=photo;
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
	
	public String getFirstName() {
		return first_name;
	}
	
	public void setFirstName(String name) {
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

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}	
}
