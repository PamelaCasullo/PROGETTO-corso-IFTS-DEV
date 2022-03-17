package it.red.teacher;

import org.springframework.web.multipart.MultipartFile;

public class Photo {
	int id_teacher;
	String institutional_email;
	MultipartFile uploadfile;
	
	public Photo(int id_teacher, String institutional_email, MultipartFile uploadfile) {
		super();
		this.id_teacher = id_teacher;
		this.institutional_email = institutional_email;
		this.uploadfile = uploadfile;
	}

	public int getId_teacher() {
		return id_teacher;
	}

	public void setId_teacher(int id_teacher) {
		this.id_teacher = id_teacher;
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
