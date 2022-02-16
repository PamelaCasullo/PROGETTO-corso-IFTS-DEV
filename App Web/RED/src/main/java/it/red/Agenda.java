package it.red;

import java.sql.Date;

public class Agenda {
	private int id_agenda;
	private Date date;
	private String description;
	private int agenda_id_module;
	private int agenda_id_teacher;

	public Agenda(int id_agenda, Date date, String description, int agenda_id_module, int agenda_id_teacher) {
		this.id_agenda = id_agenda;
		this.date = date;
		this.description = description;
		this.agenda_id_module = agenda_id_module;
		this.agenda_id_teacher = agenda_id_teacher;
	}
	
	public int getId_agenda() {
		return id_agenda;
	}
	
	public void setId_agenda(int id_agenda) {
		this.id_agenda = id_agenda;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getModule_id_module() {
		return agenda_id_module;
	}
	
	public void setModule_id_module(int module_id_module) {
		this.agenda_id_module = module_id_module;
	}
		
	public int getTeacher_id_teacher() {
		return agenda_id_teacher;
	}
	
	public void setTeacher_id_teacher(int teacher_id_teacher) {
		this.agenda_id_teacher = teacher_id_teacher;
	}
}
