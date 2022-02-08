package it.red;

import java.sql.Date;

public class Communication {
	private int id_communication;
	private Date date;
	private String text_of_communication;
	private int course_id_course;
	
	public Communication(int id_communication, Date date, String text_of_communication, int course_id_course) {
		this.id_communication = id_communication;
		this.date = date;
		this.text_of_communication = text_of_communication;
		this.course_id_course = course_id_course;
	}

	public int getId_communication() {
		return id_communication;
	}

	public void setId_communication(int id_communication) {
		this.id_communication = id_communication;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getText_of_communication() {
		return text_of_communication;
	}

	public void setText_of_communication(String text_of_communication) {
		this.text_of_communication = text_of_communication;
	}

	public int getCourse_id_course() {
		return course_id_course;
	}

	public void setCourse_id_course(int course_id_course) {
		this.course_id_course = course_id_course;
	}
	
	
}
