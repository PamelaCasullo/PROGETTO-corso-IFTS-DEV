package it.red;
/*
 select distinct lesson.presence,module.title, agenda.date from student 
inner join lesson on lesson.student_id_student=student.id_student 
inner join agenda on agenda.id_agenda=lesson.agenda_id_agenda
inner join module on agenda.module_id_module=module.id_module

where student.id_student=1 
*/
public class StudentShowPresences {
	private boolean presence;
	private String title;
	private String date;
	public StudentShowPresences() {
		
	}
	public StudentShowPresences(boolean presence,String title, String date) {
		this.presence=presence;
		this.date=date;
		this.title=title;
	}
	public boolean isPresence() {
		return presence;
	}
	public void setPresence(boolean presence) {
		this.presence = presence;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	

}
