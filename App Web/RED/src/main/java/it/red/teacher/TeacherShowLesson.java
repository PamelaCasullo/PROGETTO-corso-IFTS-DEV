package it.red.teacher;
/*select distinct agenda.date, module.title from teacher
left join agenda
on agenda.teacher_id_teacher=teacher.id_teacher
left join module
on agenda.module_id_module=module.id_module
where teacher.id_teacher=1*/

import java.sql.Date;

public class TeacherShowLesson {
	
	private Date date;
	private String title;
	
	public TeacherShowLesson() {
		
	}
	public TeacherShowLesson(Date date,String title) {
		this.date=date;
		this.title=title;
		
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTitle() {
		return title;
	}

}
