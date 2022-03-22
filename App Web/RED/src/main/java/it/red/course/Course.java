package it.red.course;

import java.sql.Date;

public class Course {
	private long id_course;
	private String name;
	private Date start_date;
	private String type_of_course;
	private long institution_id_institution;
	
	public Course(long id_course, String name, Date start_date, String type_of_course, long institution_id_institution) {
		this.id_course = id_course;
		this.name = name;
		this.start_date = start_date;
		this.type_of_course = type_of_course;
		this.institution_id_institution = institution_id_institution;
	}

	public long getId_course() {
		return id_course;
	}

	public void setId_course(long id_course) {
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

	public long getInstitution_id_institution() {
		return institution_id_institution;
	}

	public void setInstitution_id_institution(long institution_id_institution) {
		this.institution_id_institution = institution_id_institution;
	}
	
	
}
