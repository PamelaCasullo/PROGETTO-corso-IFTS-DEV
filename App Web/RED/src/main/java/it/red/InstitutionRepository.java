package it.red;

import java.util.List;

public interface InstitutionRepository {
	
	//POST
		//salva un T del DB. Ritorna 1 se modifica effettuata, altrimenti ritorna -1) 
		int save(Institution p);
		
		//GET
		//recupera al DB un T
		Institution findValueById(long id);
		
		//GET
		//recupera una lista di tutti T
		List<Institution> findAll();
		
		//GET
		//aggiorno un T, passandogli un T
		long updateValueById(Institution p);
			
		//GET
		//Cancello un T dal DB tramite id T

		int deleteValueById(long id);
		
		//GET
		//cancella tutti i record
		int deleteAll();

		
		
}
