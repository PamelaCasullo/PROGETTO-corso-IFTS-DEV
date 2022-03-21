package it.red.teacher;

import java.sql.Date;

/*select distinct student.last_name,student.first_name, lesson.grade, agenda.date  from teacher
left join agenda on agenda.teacher_id_teacher=teacher.id_teacher
left join module on module.id_module=agenda.module_id_module
left join lesson on lesson.agenda_id_agenda=agenda.id_agenda
left join student on lesson.student_id_student=student.id_student 
where teacher.id_teacher=1 and module.title = "IoT"
 */
public class VoteTeacher {
	private String first_name;
	private String last_name;
	private Date date;
	private int grade;
	
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
	
	

}
