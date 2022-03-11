package it.red;

import org.springframework.web.multipart.MultipartFile;

public class Photo {
	String institutional_email;
	MultipartFile uploadfile;
	
	public Photo(String institutional_email, MultipartFile uploadfile) {
		this.institutional_email = institutional_email;
		this.uploadfile = uploadfile;
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
