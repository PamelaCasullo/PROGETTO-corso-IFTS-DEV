package it.rizzoli.RED.Connection;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Teacher implements Serializable {
    @SerializedName("first_name")
    @Expose
    private String first_name;
    @SerializedName("last_name")
    @Expose
    private String last_name;
    @SerializedName("phone_number")
    @Expose
    private String phone_number;
    @SerializedName("personal_email")
    @Expose
    private String personal_email;
    @SerializedName("institutional_email")
    @Expose
    private String institutional_email;
    @SerializedName("id_teacher")
    @Expose
    private int id_teacher;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("photo")
    @Expose
    private String photo;

    public Teacher(){

    }

    public Teacher(String first_name, String last_name, String phone_number, String personal_email, String institutional_email, int id_teacher, String password, String photo) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone_number = phone_number;
        this.personal_email = personal_email;
        this.institutional_email = institutional_email;
        this.id_teacher = id_teacher;
        this.password = password;
        this.photo = photo;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
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

    public int getId_teacher() {
        return id_teacher;
    }

    public void setId_teacher(int id_teacher) {
        this.id_teacher = id_teacher;
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
