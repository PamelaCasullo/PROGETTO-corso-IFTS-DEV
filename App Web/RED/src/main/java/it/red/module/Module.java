package it.red.module;

public class Module {
	private long id_module;
	private String title;
	private long duration;
	private String program;
	private long course_id_course;
	
	public Module() {
		
	}
	
	public Module(long id_module, String title, long duration, String program, long course_id_course) {
		this.id_module = id_module;
		this.title = title;
		this.duration = duration;
		this.program = program;
		this.course_id_course = course_id_course;
	}

	public long getId_module() {
		return id_module;
	}

	public void setId_module(long id_module) {
		this.id_module = id_module;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}

	public String getProgram() {
		return program;
	}

	public void setProgram(String program) {
		this.program = program;
	}

	public long getCourse_id_course() {
		return course_id_course;
	}

	public void setCourse_id_course(long course_id_course) {
		this.course_id_course = course_id_course;
	}
	
	
}
