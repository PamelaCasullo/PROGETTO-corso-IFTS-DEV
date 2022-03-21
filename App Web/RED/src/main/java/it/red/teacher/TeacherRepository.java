package it.red.teacher;

import java.util.List;

import it.red.lesson.Lesson;
import it.red.student.Student;

public interface TeacherRepository {
	//POST
	//salva un T del DB. Ritorna 1 se modifica effettuata, altrimenti ritorna -1) 
	int save(Teacher p);
	
	//GET
	//recupera al DB un T
	Teacher findValueById(long id);
	
	//GET
	//recupera una lista di tutti T
	List<Teacher> findAll();
	
	//GET
	//aggiorno un T, passandogli un T
	long updateValueById(Teacher p);
		
	//GET
	//Cancello un T dal DB tramite id T

	int deleteValueById(long id);
	
	//GET
	//cancella tutti i record
	int deleteAll();

	List<Teacher> findEmailPassword(String emailq, String passwordq);
	
	long uploadPhoto(Photo photo);
	
	Teacher downloadPhoto(long id_teacher);
	
	public List<TeacherShowLesson> SearchLessonById(long id);
	
	public List<TeacherShowGrades> SearchGradeById(long id);
	
	public List<ModuleTeacher> SearchModuleById(long id);
	
	public List<VoteTeacher> ShowGradeById(long id, String title);
	public int saveVoto(Lesson p);
	public List<Student> showStudentByTeacher(long id);




}
