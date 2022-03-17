package it.rizzoli.RED;

import java.io.File;

public class Photo {
    String institutional_email;
    File uploadfile;

    public Photo(String institutional_email, File uploadfile) {
        this.institutional_email = institutional_email;
        this.uploadfile = uploadfile;
    }

    public String getInstitutional_email() {
        return institutional_email;
    }

    public void setInstitutional_email(String institutional_email) {
        this.institutional_email = institutional_email;
    }

    public File getUploadfile() {
        return uploadfile;
    }

    public void setUploadfile(File uploadfile) {
        this.uploadfile = uploadfile;
    }
}
