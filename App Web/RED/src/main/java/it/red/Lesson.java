package it.red;

public class Lesson {
	private int id_lesson;
	private int agenda_id_agenda;
	private boolean teacher_presence;
	private int grade;
	private int student_id_student;
	
	public Lesson(int id_lesson, int agenda_id_agenda, boolean teacher_presence, int grade, int student_id_student) {
		this.id_lesson = id_lesson;
		this.agenda_id_agenda = agenda_id_agenda;
		this.teacher_presence = teacher_presence;
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
	
	public boolean getTeacher_presence() {
		return teacher_presence;
	}
	public void setTeacher_presence(boolean teacher_presence) {
		this.teacher_presence = teacher_presence;
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
