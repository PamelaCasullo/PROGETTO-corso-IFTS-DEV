package it.red;

public class StudentShowGrades {
	/*
			select teacher.first_name,teacher.last_name, lesson.grade, module.title, agenda.date from student 
right join lesson on lesson.student_id_student=student.id_student 
left join agenda on agenda.id_agenda=lesson.agenda_id_agenda 
left join module on module.id_module=agenda.module_id_module 
left join teacher on agenda.teacher_id_teacher=id_teacher
where student.id_student=1 and lesson.grade IS NOT NULL
	 */
	private String first_name;
	private String last_name;
	private String date;
	private String grade;
	private String title;

	public StudentShowGrades() {

	}
	public StudentShowGrades(String first_name,String last_name,String grade, String title,String date) {
		this.first_name=first_name;
		this.last_name=last_name;
		this.grade=grade;
		this.title=title;
		this.date=date;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}



}
