package it.red;

public class Lesson {
	private int id_lesson;
	private int lesson_id_agenda;
	private boolean presence;
	private int grade;
	private int lesson_id_student;
	
	public Lesson(int id_lesson, int lesson_id_agenda, boolean presence, int grade, int lesson_id_student) {
		this.id_lesson = id_lesson;
		this.lesson_id_agenda = lesson_id_agenda;
		this.presence = presence;
		this.grade = grade;
		this.lesson_id_student = lesson_id_student;
	}
	
	public int getId_lesson() {
		return id_lesson;
	}
	
	public void setId_lesson(int id_lesson) {
		this.id_lesson = id_lesson;
	}
	
	public int getAgenda_id_agenda() {
		return lesson_id_agenda;
	}
	public void setAgenda_id_agenda(int agenda_id_agenda) {
		this.lesson_id_agenda = agenda_id_agenda;
	}
	
	public boolean getTeacher_presence() {
		return presence;
	}
	public void setTeacher_presence(boolean teacher_presence) {
		this.presence = teacher_presence;
	}
	
	public int getGrade() {
		return grade;
	}
	
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	public int getStudent_id_student() {
		return lesson_id_student;
	}
	
	public void setStudent_id_student(int student_id_student) {
		this.lesson_id_student = student_id_student;
	}
	
	
}