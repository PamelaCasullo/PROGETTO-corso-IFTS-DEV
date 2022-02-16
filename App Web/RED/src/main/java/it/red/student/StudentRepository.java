package it.red.student;

import java.util.List;



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
	
	//GET
	//aggiorno un T, passandogli un T
	long updateValueById(Student p);
		
	//GET
	//Cancello un T dal DB tramite id T

	int deleteValueById(long id);
	
	//GET
	//cancella tutti i record
	int deleteAll();

	

}