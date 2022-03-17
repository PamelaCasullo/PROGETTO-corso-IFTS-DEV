package it.red.student;

import java.util.List;

import it.red.LessonHomepageStudent;
import it.red.StudentShowGrades;
import it.red.StudentShowPresences;

public interface StudentRepository {
	
	//POST
	//salva un T del DB. Ritorna 1 se modifica effettuata, altrimenti ritorna -1) 
	int save(Student p);
	
	//GET
	//recupera al DB un T
	Student findValueById(long id);
	
	//GET
	//recupera una lista di tutti T
	List<Student> findAll();
	
	//POST
	// permette l'accesso a uno studente
	List<Student> findEmailPassword(String institutional_email, String password);
	
	//GET
	//aggiorno un T, passandogli un T
	long updateValueById(Student p);
		
	//GET
	//Cancello un T dal DB tramite id T

	int deleteValueById(long id);
	
	//GET
	//cancella tutti i record
	int deleteAll();
	//GET
	//mostra tutte le lezioni
	List<LessonHomepageStudent> SearchLessonById(long id);
	//GET
	//mostra tutti i voti
	List<StudentShowGrades> SearchGradesById(long id);
	//GET
	//mostra tutte le presenze e le assenze
	List<StudentShowPresences> SearchPresenceById(long id);
	
	long uploadPhoto(Photo photo);
	
	Student downloadPhoto(long id_student);
	
}
