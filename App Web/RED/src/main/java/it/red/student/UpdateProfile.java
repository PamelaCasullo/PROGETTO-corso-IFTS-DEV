package it.red.student;

public class UpdateProfile {
	int id_student;
	String personal_email;
	String phone_number;
	String password;
	
	public UpdateProfile() {
		
	}
	
	public UpdateProfile(int id_student, String personal_email, String phone_number, String password) {
		this.id_student = id_student;
		this.personal_email = personal_email;
		this.phone_number = phone_number;
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
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
