package it.red.agenda;

import java.util.List;

public interface AgendaRepository {

	int save(Agenda a);
	
	Agenda findValueById(long id);
	
	List<Agenda> findAll();
	
	long updateValueById(Agenda a);
	
	int deleteAll();

	int deleteValueById(long id);
}
