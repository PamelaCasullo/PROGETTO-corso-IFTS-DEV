package it.red.teacher;

public class UpdateProfile {
	int id_teacher;
	String personal_email;
	String phone_number;
	String password;
	
	public UpdateProfile() {
		
	}
	
	public UpdateProfile(int id_teacher, String personal_email, String phone_number, String password) {
		super();
		this.id_teacher = id_teacher;
		this.personal_email = personal_email;
		this.phone_number = phone_number;
		this.password = password;
	}
	
	public int getId_teacher() {
		return id_teacher;
	}
	public void setId_teacher(int id_teacher) {
		this.id_teacher = id_teacher;
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
