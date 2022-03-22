package it.red.lesson;

public class Lesson {
	private long id_lesson;
	private long agenda_id_agenda;
	private boolean presence;
	private long grade;
	private long student_id_student;
	
	public Lesson() {}
	
	public Lesson(long id_lesson, long agenda_id_agenda, boolean presence, long grade, long student_id_student) {
		this.id_lesson = id_lesson;
		this.agenda_id_agenda = agenda_id_agenda;
		this.presence = presence;
		this.grade = grade;
		this.student_id_student = student_id_student;
	}
	
	public long getId_lesson() {
		return id_lesson;
	}
	
	public void setId_lesson(long id_lesson) {
		this.id_lesson = id_lesson;
	}
	
	public long getAgenda_id_agenda() {
		return agenda_id_agenda;
	}
	public void setAgenda_id_agenda(long agenda_id_agenda) {
		this.agenda_id_agenda = agenda_id_agenda;
	}
	
	public boolean getPresence() {
		return presence;
	}
	public void setPresence(boolean presence) {
		this.presence = presence;
	}
	
	public long getGrade() {
		return grade;
	}
	
	public void setGrade(long grade) {
		this.grade = grade;
	}
	
	public long getStudent_id_student() {
		return student_id_student;
	}
	
	public void setStudent_id_student(long student_id_student) {
		this.student_id_student = student_id_student;
	}
	
	
}
