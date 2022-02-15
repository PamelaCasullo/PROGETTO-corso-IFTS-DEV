package it.red;

public class Module {
	private int id_module;
	private String title;
	private int duration;
	private String program;
	private int module_id_course;
	
	public Module(int id_module, String title, int duration, String program, int module_id_course) {
		this.id_module = id_module;
		this.title = title;
		this.duration = duration;
		this.program = program;
		this.module_id_course = module_id_course;
	}

	public int getId_module() {
		return id_module;
	}

	public void setId_module(int id_module) {
		this.id_module = id_module;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getProgram() {
		return program;
	}

	public void setProgram(String program) {
		this.program = program;
	}

	public int getCourse_id_course() {
		return module_id_course;
	}

	public void setCourse_id_course(int course_id_course) {
		this.module_id_course = course_id_course;
	}
	
	
}
