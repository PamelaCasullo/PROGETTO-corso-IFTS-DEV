package it.red.agenda;

import java.sql.Date;

public class Agenda {
	private long id_agenda;
	private Date date;
	private String description;
	private boolean sign;
	private long module_id_module;
	private long teacher_id_teacher;

	public Agenda() {
		
	}
	
	public Agenda(long id_agenda, Date date, String description, boolean sign, long module_id_module, long teacher_id_teacher) {
		this.id_agenda = id_agenda;
		this.date = date;
		this.description = description;
		this.sign = sign;
		this.module_id_module = module_id_module;
		this.teacher_id_teacher = teacher_id_teacher;
	}
	
	public long getId_agenda() {
		return id_agenda;
	}
	
	public void setId_agenda(long id_agenda) {
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
	
	public boolean getSign() {
		return sign;
	}
	
	public void setSign(boolean sign) {
		this.sign = sign;
	}
	
	public long getModule_id_module() {
		return module_id_module;
	}
	
	public void setModule_id_module(long module_id_module) {
		this.module_id_module = module_id_module;
	}
		
	public long getTeacher_id_teacher() {
		return teacher_id_teacher;
	}
	
	public void setTeacher_id_teacher(long teacher_id_teacher) {
		this.teacher_id_teacher = teacher_id_teacher;
	}
}
