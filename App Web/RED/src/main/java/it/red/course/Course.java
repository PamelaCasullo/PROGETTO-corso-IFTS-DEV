package it.red.course;

import java.sql.Date;

public class Course {
	private int id_course;
	private String name;
	private Date start_date;
	private String type_of_course;
	private int institution_id_institution;
	
	public Course(int id_course, String name, Date start_date, String type_of_course, int institution_id_institution) {
		this.id_course = id_course;
		this.name = name;
		this.start_date = start_date;
		this.type_of_course = type_of_course;
		this.institution_id_institution = institution_id_institution;
	}

	public int getId_course() {
		return id_course;
	}

	public void setId_course(int id_course) {
		this.id_course = id_course;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public String getType_of_course() {
		return type_of_course;
	}

	public void setType_of_course(String type_of_course) {
		this.type_of_course = type_of_course;
	}

	public int getInstitution_id_institution() {
		return institution_id_institution;
	}

	public void setInstitution_id_institution(int institution_id_institution) {
		this.institution_id_institution = institution_id_institution;
	}
	
	
}
