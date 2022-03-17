package it.red.student;

import org.springframework.web.multipart.MultipartFile;

public class Photo {
	int id_student;
	String institutional_email;
	MultipartFile uploadfile;
	
	public Photo(int id_student, String institutional_email, MultipartFile uploadfile) {
		super();
		this.id_student = id_student;
		this.institutional_email = institutional_email;
		this.uploadfile = uploadfile;
	}

	public int getId_student() {
		return id_student;
	}

	public void setId_student(int id_student) {
		this.id_student = id_student;
	}

	public String getInstitutional_email() {
		return institutional_email;
	}

	public void setInstitutional_email(String institutional_email) {
		this.institutional_email = institutional_email;
	}

	public MultipartFile getUploadfile() {
		return uploadfile;
	}

	public void setUploadfile(MultipartFile uploadfile) {
		this.uploadfile = uploadfile;
	}
	
}
