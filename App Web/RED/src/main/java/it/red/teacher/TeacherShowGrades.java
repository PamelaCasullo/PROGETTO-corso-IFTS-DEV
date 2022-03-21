package it.red.teacher;

import java.sql.Date;

public class TeacherShowGrades {

	/*select distinct student.first_name, student.last_name, lesson.grade,module.title, agenda.date from teacher
				left join agenda on agenda.teacher_id_teacher=teacher.id_teacher
                left join module on module.id_module=agenda.module_id_module
                left join lesson on lesson.agenda_id_agenda=agenda_id_agenda
                left join student on student.id_student=lesson.student_id_student
                where lesson.grade !=0 and teacher.id_teacher=1
                */
	
	private String first_name;
	private String last_name;
	private int grade;
	private String title;
	private Date date;
	
	public TeacherShowGrades(String first_name, String last_name, int grade, String title, Date date) {
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

	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
	
}
