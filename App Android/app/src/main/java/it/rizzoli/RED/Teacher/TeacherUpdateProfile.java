package it.rizzoli.RED.Teacher;

public class TeacherUpdateProfile {

    int id_teacher;
    String personal_email;
    String phone_number;
    String password;

    public TeacherUpdateProfile() {
    }

    public TeacherUpdateProfile(int id_teacher, String personal_email, String phone_number, String password) {
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
