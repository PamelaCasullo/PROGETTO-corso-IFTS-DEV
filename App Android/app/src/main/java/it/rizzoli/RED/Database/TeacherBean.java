package it.rizzoli.RED.Database;

public class TeacherBean {

	private int id_teacher;
	private String personal_email;
	private String institutional_email;
	private String first_name;
	private String last_name;
	private String phone_number;
	private String password;
	private String photo;

	public TeacherBean() {
		
	}
	
	public TeacherBean(int id_teacher, String personal_email, String institutional_email, String first_name, String last_name, String phone_number, String password,String photo) {
		this.id_teacher = id_teacher;
		this.personal_email = personal_email;
		this.institutional_email = institutional_email;
		this.first_name = first_name;
		this.last_name = last_name;
		this.phone_number = phone_number;
		this.password = password;
		this.photo = photo;
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
