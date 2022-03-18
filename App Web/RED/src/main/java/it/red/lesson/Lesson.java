package it.red.lesson;

public class Lesson {
	private int id_lesson;
	private int agenda_id_agenda;
	private boolean presence;
	private int grade;
	private int student_id_student;
	
	public Lesson() {}
	
	public Lesson(int id_lesson, int agenda_id_agenda, boolean presence, int grade, int student_id_student) {
		this.id_lesson = id_lesson;
		this.agenda_id_agenda = agenda_id_agenda;
		this.presence = presence;
		this.grade = grade;
		this.student_id_student = student_id_student;
	}
	
	public int getId_lesson() {
		return id_lesson;
	}
	
	public void setId_lesson(int id_lesson) {
		this.id_lesson = id_lesson;
	}
	
	public int getAgenda_id_agenda() {
		return agenda_id_agenda;
	}
	public void setAgenda_id_agenda(int agenda_id_agenda) {
		this.agenda_id_agenda = agenda_id_agenda;
	}
	
	public boolean getPresence() {
		return presence;
	}
	public void setPresence(boolean presence) {
		this.presence = presence;
	}
	
	public int getGrade() {
		return grade;
	}
	
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	public int getStudent_id_student() {
		return student_id_student;
	}
	
	public void setStudent_id_student(int student_id_student) {
		this.student_id_student = student_id_student;
	}
	
	
}
