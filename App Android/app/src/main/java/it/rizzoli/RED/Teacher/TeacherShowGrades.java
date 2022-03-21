package it.rizzoli.RED.Teacher;

public class TeacherShowGrades {
    private String first_name;
    private String last_name;
    private int grade;
    private String title;
    private String date;

    public TeacherShowGrades(String first_name, String last_name, int grade, String title, String date) {
        this.first_name=first_name;
        this.last_name=last_name;
        this.grade=grade;
        this.title=title;
        this.date=date;
    }
    public TeacherShowGrades() {

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
    public int getGrade() {
        return grade;
    }
    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

}
