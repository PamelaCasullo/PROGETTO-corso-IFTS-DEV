package it.red;

import java.util.Date;

public class LessonHomepageStudent {
	private String first_name;
	private String last_name;
	private String title;
	private Date date;

	public LessonHomepageStudent(String first_name, String last_name, Date date, String title) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.title = title;
		this.date = date;
	}
	public LessonHomepageStudent() {

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
